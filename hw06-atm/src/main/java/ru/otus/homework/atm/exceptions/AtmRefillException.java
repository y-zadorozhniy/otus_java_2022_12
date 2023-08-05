package ru.otus.homework.atm.exceptions;

public class AtmRefillException extends RuntimeException {
    public AtmRefillException(String msg) {
        super(msg);
    }
}