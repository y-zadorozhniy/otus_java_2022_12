package ru.otus.lombok;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

@UtilityClass
public class UtilityBox {

    public String join(int[] objects) {
        return Arrays.stream(objects)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
