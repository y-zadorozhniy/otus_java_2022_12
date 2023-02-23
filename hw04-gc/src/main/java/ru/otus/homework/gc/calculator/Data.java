package ru.otus.homework.gc.calculator;

// Оптимизация: заменен тип Integer на int, т.к. он все равно final, не подразумевает null
public class Data {
    private final int value;

    public Data(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
