package ru.otus.lombok.equality;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.otus.lombok.equality.ColoredPoint;
import ru.otus.lombok.equality.Point;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void equalsTest() {
        val a = new Point(10, 12);
        val b = new ColoredPoint(10, 12, Color.BLACK);
        val c = new ColoredPoint(10, 12, Color.BLUE);

        assertAll(() -> assertEquals(a, a, "reflexive"),
                () -> assertEquals(a.equals(b), b.equals(a), "symmetric"),
                () -> assertTrue(!a.equals(b) && !a.equals(c) && !b.equals(c), "transitive"),
                () -> assertNotEquals(null, a, "not-nullable")
        );
    }
}