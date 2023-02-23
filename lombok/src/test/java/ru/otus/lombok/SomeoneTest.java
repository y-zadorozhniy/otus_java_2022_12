package ru.otus.lombok;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeoneTest {

    @Test
    void someonesTest() {
        var someOne = Someone.getNew();
        val sam = new Sam("Sam");

        assertEquals("Sam", sam.name());
        assertEquals("Yeah!", someOne.someField());
    }

    @Test
    void longTextShortTest() {
        val man = new Sam("Samuel");
        String actual = man.toString();
        assertEquals("Sam(Sam)", actual);
    }
}