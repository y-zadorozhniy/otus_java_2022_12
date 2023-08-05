package ru.otus.homework.atm;

import java.util.Set;

public interface Atm {

    void add(Banknote banknote);

    Set<Banknote> get(long amount);

    Long balance();
}
