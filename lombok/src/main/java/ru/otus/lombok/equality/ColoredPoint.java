package ru.otus.lombok.equality;

import java.awt.*;

public class ColoredPoint extends Point {

    private Color color;

    public ColoredPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || super.equals(other)
                && other instanceof ColoredPoint point
                && point.color == this.color;
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof ColoredPoint;
    }
}
