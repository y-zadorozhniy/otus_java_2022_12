package ru.otus.lombok;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JaguarTest {

    @Test
    void constructorTest() {
        Jaguar jaguar = new Jaguar(10, 10);
        val j = jaguar.withWeight(15);
        int ordinal = Type.ANIMAL.ordinal();
        val town = Town.builder().build();
        Assertions.assertEquals(1, ordinal);
    }
}