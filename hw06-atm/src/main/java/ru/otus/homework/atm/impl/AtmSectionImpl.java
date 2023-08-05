package ru.otus.homework.atm.impl;

import ru.otus.homework.atm.AtmSection;
import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.exceptions.AtmWithdrawalException;

import java.util.Stack;

public class AtmSectionImpl implements AtmSection {

    private final Stack<Banknote> banknotes;
    private final BanknoteType banknoteType;

    public AtmSectionImpl(BanknoteType banknoteType) {
        this.banknotes = new Stack<>();
        this.banknoteType = banknoteType;
    }

    @Override
    public void add(Banknote banknote) {
        banknotes.add(banknote);
    }

    @Override
    public Banknote get() {
        if (banknotes.isEmpty()) {
            throw new AtmWithdrawalException("Отсутствуют купюры с номиналом " + banknoteType.getSum());
        }
        return banknotes.pop();
    }

    @Override
    public int getBanknoteSum() {
        return banknoteType.getSum();
    }

    @Override
    public int getAmount() {
        return banknotes.size();
    }
}
