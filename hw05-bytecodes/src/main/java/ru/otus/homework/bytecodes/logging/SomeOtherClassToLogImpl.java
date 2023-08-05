package ru.otus.homework.bytecodes.logging;

import ru.otus.homework.bytecodes.annotations.Log;

public class SomeOtherClassToLogImpl implements SomeOtherClassToLog {

    @Log
    @Override
    public void someMethod(int param) {
        System.out.println("let's print param - " + param);
    }

    @Override
    public void someOtherMethod(int param) {
        System.out.println("this code damn universal (no)");
    }
}
