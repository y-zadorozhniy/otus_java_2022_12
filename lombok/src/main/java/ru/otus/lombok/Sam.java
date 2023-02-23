package ru.otus.lombok;

import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode
@ToString(doNotUseGetters = true, includeFieldNames = false)
@AllArgsConstructor
public class Sam extends Someone {
    @Setter
    @Getter
    String name;

    @ToString.Include(name = "name")
    public String name() {
        return name.substring(0, 3);
    }
}
