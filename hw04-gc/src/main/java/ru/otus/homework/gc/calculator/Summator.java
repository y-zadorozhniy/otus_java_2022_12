package ru.otus.homework.gc.calculator;

import java.util.ArrayList;
import java.util.List;

// Оптимизация: задан изначальный размер ArrayList, т.к. мы знаем, что каждые 6_600_000 список обнуляется
public class Summator {
    private int sum;
    private int prevValue;
    private int prevPrevValue;
    private int sumLastThreeValues;
    private int someValue;

    private final List<Data> listValues = new ArrayList<>(6_600_000);

    //!!! сигнатуру метода менять нельзя
    public void calc(Data data) {
        if (listValues.size() % 6_600_000 == 0) {
            listValues.clear();
        }
        sum += data.getValue();

        sumLastThreeValues = data.getValue() + prevValue + prevPrevValue;

        prevPrevValue = prevValue;
        prevValue = data.getValue();

        for (var idx = 0; idx < 3; idx++) {
            someValue += (sumLastThreeValues * sumLastThreeValues / (data.getValue() + 1) - sum);
            someValue = Math.abs(someValue) + listValues.size();
        }
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getPrevValue() {
        return prevValue;
    }

    public Integer getPrevPrevValue() {
        return prevPrevValue;
    }

    public Integer getSumLastThreeValues() {
        return sumLastThreeValues;
    }

    public Integer getSomeValue() {
        return someValue;
    }
}
