package ru.otus.homework.atm.impl;

public enum BanknoteType {

    HUNDRED(100),
    FIVE_HUNDREDS(500),
    THOUSAND(1000),
    FIVE_THOUSANDS(5000);

    BanknoteType(int sum) {
        this.sum = sum;
    }

    private final int sum;

    public int getSum() {
        return this.sum;
    }
}
