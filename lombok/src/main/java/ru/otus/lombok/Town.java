package ru.otus.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Town {
    private boolean isAwesome;

    @Setter
    @ToString
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    public static class TownBuilder {

        int id;
        boolean isAwesome;

        public Town build() {
            return new Town(isAwesome);
        }
    }

    public static TownBuilder builder() {
        return new TownBuilder();
    }
}
