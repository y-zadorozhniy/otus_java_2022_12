package ru.otus.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.ExtensionMethod;

import java.util.Arrays;
import java.util.List;

@Builder
@ExtensionMethod({UtilityBox.class, Arrays.class})
public class Box {

    @Getter
    @Singular
    private List<String> items;

    private int[] numbers;

    public String getNumbers() {
        numbers.sort();
        return numbers.join();
    }
}
