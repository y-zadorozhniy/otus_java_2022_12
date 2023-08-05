package ru.otus.homework.atm;

public interface AtmSection {

    void add(Banknote banknote);

    Banknote get();

    int getBanknoteSum();

    int getAmount();
}
