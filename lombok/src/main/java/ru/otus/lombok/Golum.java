package ru.otus.lombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder(toBuilder = true)
@SuppressWarnings("unused")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Golum {

    @Getter
    @Builder.ObtainVia(method = "newId")
    int id;

    boolean foundPrecious;

    private int newId() {
        return id++;
    }
}
