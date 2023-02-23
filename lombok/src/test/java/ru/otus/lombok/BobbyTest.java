package ru.otus.lombok;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BobbyTest {

    @Test
    void creationErrorTest() {
        val bobby = new Bobby();
        var actualException = assertThrows(Exception.class, bobby::getTimmy);
        assertAll(() -> assertFalse(actualException instanceof RuntimeException),
                () -> assertTrue(actualException instanceof ClassNotFoundException)
        );
    }
}