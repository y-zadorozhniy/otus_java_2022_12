package ru.otus.homework.atm.impl;

import ru.otus.homework.atm.Banknote;

public class BanknoteImpl implements Banknote {

    private final BanknoteType banknoteType;
    private final String number;

    public BanknoteImpl(BanknoteType banknoteType, String number) {
        this.banknoteType = banknoteType;
        this.number = number;
    }

    @Override
    public int getSum() {
        return banknoteType.getSum();
    }

    @Override
    public String getNumber() {
        return number;
    }
}
