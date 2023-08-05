package ru.otus.homework.bytecodes;

import ru.otus.homework.bytecodes.ioc.Ioc;
import ru.otus.homework.bytecodes.logging.*;

public class ByteCodes {

    public static void main(String[] args) {
        var testLogging = Ioc.create(TestLogging.class, new TestLoggingImpl());
        Demo demo = new Demo(testLogging);
        demo.action();
        var someOtherClassToLog = Ioc.create(SomeOtherClassToLog.class, new SomeOtherClassToLogImpl());
        someOtherClassToLog.someMethod(10);
        someOtherClassToLog.someOtherMethod(10500);
    }
}
