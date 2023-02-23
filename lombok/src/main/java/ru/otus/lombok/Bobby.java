package ru.otus.lombok;

import lombok.SneakyThrows;

public class Bobby {

    @SneakyThrows
    public Object getTimmy() {
        Class<?> aClass = Class.forName("Timmy!");
        return aClass.getDeclaredConstructor().newInstance();
    }
}
