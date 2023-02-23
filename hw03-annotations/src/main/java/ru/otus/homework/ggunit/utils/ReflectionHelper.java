package ru.otus.homework.ggunit.utils;

public final class ReflectionHelper {
    private ReflectionHelper() {
    }

    public static Class<?>[] toClasses(Object[] args) throws ClassNotFoundException {
        Class<?>[] classes = new Class[args.length];
        int i = 0;
        for (Object className : args) {
            Class<?> aClass = Class.forName((String) className);
            classes[i] = aClass;
            i++;
        }
        return classes;
    }

    public static <T> T instantiate(Class<T> type, Object... args) {
        try {
            if (args.length == 0) {
                return type.getDeclaredConstructor().newInstance();
            } else {
                Class<?>[] classes = toClasses(args);
                return type.getDeclaredConstructor(classes).newInstance(args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
