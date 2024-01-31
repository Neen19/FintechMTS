package animals.predators;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.SharkBreeds;
import animals.utils.RandomUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shark extends Predator {

    public Shark() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(SharkBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "shark character";
    }

    public Shark(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
