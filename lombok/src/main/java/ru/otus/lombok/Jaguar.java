package ru.otus.lombok;

import lombok.Data;
import lombok.Setter;
import lombok.With;

@Data
@Setter
public class Jaguar {
    private final int speed;
    @With
    private int weight;

    public Jaguar(int speed, int weight) {
        this.speed = speed;
        this.weight = weight;
    }
}