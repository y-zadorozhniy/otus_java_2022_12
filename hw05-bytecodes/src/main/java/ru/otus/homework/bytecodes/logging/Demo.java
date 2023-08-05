package ru.otus.homework.bytecodes.logging;

public class Demo {

    private final TestLogging testLogging;

    public Demo(TestLogging testLogging) {
        this.testLogging = testLogging;
    }

    public void action() {
        testLogging.calculation(6);
        testLogging.calculation(6, 2);
        testLogging.calculation(6, 2, "$");
    }
}
