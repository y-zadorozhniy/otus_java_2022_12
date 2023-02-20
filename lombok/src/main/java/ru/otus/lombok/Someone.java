package ru.otus.lombok;

import lombok.*;

@EqualsAndHashCode(exclude = "someField")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Someone {

    @Getter(AccessLevel.MODULE)
    private final String someField;

    String anotherField;

    public static Someone getNew() {
        return new Someone("Yeah!");
    }
}
