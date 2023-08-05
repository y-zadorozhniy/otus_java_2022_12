package ru.otus.homework.bytecodes.logging;

import ru.otus.homework.bytecodes.annotations.Log;

public class TestLoggingImpl implements TestLogging {

    @Log
    @Override
    public void calculation(int param1) {
        int result = param1 * 1000;
        System.out.println(result);
    }

    @Override
    public void calculation(int param1, int param2) {
        int result = (param1 + param2) * 1000;
        System.out.println(result);
    }

    @Override
    public void calculation(int param1, int param2, String param3) {
        int result = (param1 + param2) * 1000;
        System.out.println(result + " " + param3);
    }
}
