package app.animals.predators;

import app.animals.enums.AnimalNames;
import app.animals.enums.RandomEnumGenerator;
import app.animals.enums.breeds.WolfBreeds;
import app.animals.utils.RandomUtils;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(WolfBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "wolf character";
    }

    public Wolf(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
