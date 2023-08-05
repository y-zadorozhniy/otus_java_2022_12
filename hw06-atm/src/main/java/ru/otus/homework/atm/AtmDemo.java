package ru.otus.homework.atm;

import ru.otus.homework.atm.exceptions.AtmWithdrawalException;
import ru.otus.homework.atm.impl.AtmImpl;
import ru.otus.homework.atm.impl.BanknoteImpl;
import ru.otus.homework.atm.impl.BanknoteType;

public class AtmDemo {

    public static void main(String[] args) {
        Atm atm = new AtmImpl();
        System.out.println("ATM balance: " + atm.balance());

        //пополняем счет
        atm.add(new BanknoteImpl(BanknoteType.FIVE_THOUSANDS, "00001"));
        atm.add(new BanknoteImpl(BanknoteType.THOUSAND, "00002"));
        atm.add(new BanknoteImpl(BanknoteType.HUNDRED, "00011"));
        atm.add(new BanknoteImpl(BanknoteType.HUNDRED, "99999"));
        System.out.println("ATM balance: " + atm.balance());

        //снимаем сумму на которую достаточно купюр
        atm.get(1100L);
        System.out.println("ATM balance: " + atm.balance());

        //снимаем некорректную сумму
        try {
            atm.get(10L);
        } catch (AtmWithdrawalException exception) {
            System.out.println(exception.getMessage());
        }

        //снимаем корректную сумму, которую невозможно снять из-за отсутствия купюр нужного номинала
        try {
            atm.get(200L);
        } catch (AtmWithdrawalException exception) {
            System.out.println(exception.getMessage());
        }

        //проверяем, что сумма не изменилась
        System.out.println("ATM balance: " + atm.balance());
    }
}
