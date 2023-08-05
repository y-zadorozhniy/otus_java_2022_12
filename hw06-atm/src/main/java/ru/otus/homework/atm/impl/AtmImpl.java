package ru.otus.homework.atm.impl;

import ru.otus.homework.atm.Atm;
import ru.otus.homework.atm.AtmSection;
import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.exceptions.AtmRefillException;
import ru.otus.homework.atm.exceptions.AtmWithdrawalException;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class AtmImpl implements Atm {

    private final Set<AtmSection> sections;

    public AtmImpl() {
        this.sections = new TreeSet<>(Comparator.comparingInt(AtmSection::getBanknoteSum).reversed());
        Stream.of(BanknoteType.values())
                .forEach(banknoteType -> sections.add(new AtmSectionImpl(banknoteType)));
    }

    @Override
    public void add(Banknote banknote) {
        AtmSection atmSection = sections.stream()
                .filter(section -> section.getBanknoteSum() == banknote.getSum())
                .findFirst()
                .orElseThrow(() -> new AtmRefillException("Банкомат не принимает данный тип банкнот"));
        atmSection.add(banknote);
    }

    @Override
    public Set<Banknote> get(long sum) {
        Set<Banknote> output = new HashSet<>();
        long sumLeft = sum;
        for (AtmSection atmSection : sections) {
            while (sumLeft >= atmSection.getBanknoteSum() && atmSection.getAmount() > 0) {
                Banknote banknote = atmSection.get();
                output.add(banknote);
                sumLeft -= banknote.getSum();
            }
        }
        if(sumLeft != 0) {
            revertTransaction(output);
            throw new AtmWithdrawalException("Запрошенная сумма не может быть выдана!");
        }
        return output;
    }

    @Override
    public Long balance() {
        return sections.stream()
                .map(atmSection -> (long) atmSection.getAmount() * atmSection.getBanknoteSum())
                .mapToLong(Long::longValue)
                .sum();
    }

    private void revertTransaction(Set<Banknote> banknotes) {
        banknotes.forEach(this::add);
    }
}
