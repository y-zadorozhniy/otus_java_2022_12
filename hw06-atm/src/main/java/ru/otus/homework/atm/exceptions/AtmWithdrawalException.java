package ru.otus.homework.atm.exceptions;

public class AtmWithdrawalException extends RuntimeException {
    public AtmWithdrawalException(String msg) {
        super(msg);
    }
}