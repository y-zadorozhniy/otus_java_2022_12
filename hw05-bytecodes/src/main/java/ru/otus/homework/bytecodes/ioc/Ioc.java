package ru.otus.homework.bytecodes.ioc;

import ru.otus.homework.bytecodes.annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Ioc {

    private Ioc() {
    }

    public static <T> T create(Class<T> interfaceClass, T instance) {
        InvocationHandler handler = new LoggingInvocationHandler(instance);
        return (T) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{interfaceClass}, handler);
    }

    static class LoggingInvocationHandler implements InvocationHandler {

        private final Object targetInstance;

        private final Set<String> methodsToLog;

        LoggingInvocationHandler(Object targetInstance) {
            this.targetInstance = targetInstance;
            methodsToLog = Arrays.stream(targetInstance.getClass().getMethods())
                    .filter(method -> Arrays.stream(method.getAnnotations())
                            .anyMatch(Log.class::isInstance))
                    .map(this::getMethodDesciption)
                    .collect(Collectors.toUnmodifiableSet());
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methodsToLog.contains(getMethodDesciption(method))) {
                System.out.println("invoking method: " + method + " param: " +
                        Arrays.stream(args)
                                .map(String::valueOf)
                                .collect(Collectors.joining(", ")));
            }
            return method.invoke(targetInstance, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + targetInstance +
                    '}';
        }

        private String getMethodDesciption(Method method) {
            return String.format("%s %s %s", method.getReturnType().getName(), method.getName(),
                    Arrays.stream(method.getParameters())
                            .map(parameter -> String.valueOf(parameter.getType()))
                            .collect(Collectors.joining(",")));
        }
    }
}
