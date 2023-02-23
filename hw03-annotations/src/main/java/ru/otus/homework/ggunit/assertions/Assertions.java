package ru.otus.homework.ggunit.assertions;

import ru.otus.homework.ggunit.exceptions.TestFailedException;

public final class Assertions {

    private Assertions() {
    }

    public static void assertEquals(Object a, Object b) {
        if (a != b) {
            String message = "Elements is not equals! Expected: " +
                    a.toString() +
                    " Got: " +
                    b.toString();
            throw new TestFailedException(message);
        }
    }
}
