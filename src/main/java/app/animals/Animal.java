package app.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
    String getBreed();

    String getName();

    BigDecimal getCost();

    String getCharacter();

    LocalDate getBirthDate();

}
