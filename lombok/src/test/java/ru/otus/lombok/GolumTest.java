package ru.otus.lombok;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GolumTest {

    @Test
    void testGolum() {
        val golum = Golum.builder()
                .id(1)
                .foundPrecious(false)
                .build();
        golum.toBuilder().build();
        assertEquals(2, golum.id());
    }
}