package ru.otus.homework.ggunit;

import ru.otus.homework.ggunit.annotations.After;
import ru.otus.homework.ggunit.annotations.Before;
import ru.otus.homework.ggunit.annotations.Test;
import ru.otus.homework.ggunit.utils.ReflectionHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GGUnit {

    private static int success;
    private static int failed;

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?>[] classes = ReflectionHelper.toClasses(args);
        for (Class<?> aClass : classes) {
            runTests(aClass);
        }
        System.out.printf("All tests complete. Success: %d. Failed: %d.", success, failed);
    }

    private static void runTests(Class<?> testClass) {
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        List<Method> tests = new ArrayList<>();

        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                if (annotation instanceof Before) {
                    beforeMethods.add(method);
                }
                if (annotation instanceof After) {
                    afterMethods.add(method);
                }
                if (annotation instanceof Test) {
                    tests.add(method);
                }
            }
        }

        tests.forEach(testMethod -> {
            try {
                runTest(ReflectionHelper.instantiate(testClass), testMethod, beforeMethods, afterMethods);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    private static void runTest(Object testInstance,
                                Method testMethod,
                                List<Method> beforeMethods,
                                List<Method> afterMethods)
            throws InvocationTargetException, IllegalAccessException {
        for (Method beforeMethod : beforeMethods) {
            System.out.println("Before method run");
            runMethod(beforeMethod, testInstance);
        }
        try {
            System.out.printf("Run test %s%n", testMethod.getName());
            runMethod(testMethod, testInstance);
            success++;
        } catch (Exception e) {
            e.printStackTrace();
            failed++;
        }
        for (Method afterMethod : afterMethods) {
            System.out.println("After method run");
            runMethod(afterMethod, testInstance);
        }
    }

    private static void runMethod(Method method, Object testInstance)
            throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        method.invoke(testInstance);
    }
}
