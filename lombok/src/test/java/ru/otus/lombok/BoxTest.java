package ru.otus.lombok;

import lombok.extern.jackson.Jacksonized;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Jacksonized
class BoxTest {

    @Test
    void boxTest() {
        var box = Box.builder()
                .item("one")
                .item("two")
                .build();
    }

    @Test
    void numbersTest() {
        var box = Box.builder()
                .numbers(new int[]{6, 5, 4})
                .build();
        Assertions.assertEquals("1,5,6",box.getNumbers());
    }
}