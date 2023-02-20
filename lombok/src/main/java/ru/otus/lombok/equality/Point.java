package ru.otus.lombok.equality;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || other instanceof Point point
                && point.canEqual(this)
                && point.x == this.x
                && point.y == this.y;
    }

    protected boolean canEqual(Object other) {
        return true;
    }
}
