package ru.otus.homework.ggunit.exceptions;

public class TestFailedException extends RuntimeException {

    public final String message;

    public TestFailedException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
