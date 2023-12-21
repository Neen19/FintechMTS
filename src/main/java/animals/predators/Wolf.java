package main.java.animals.predators;

import main.java.animals.enums.AnimalNames;
import main.java.animals.enums.RandomEnumGenerator;
import main.java.animals.enums.breeds.WolfBreeds;
import main.java.animals.utils.RandomUtils;


public class Wolf extends Predator {
    public Wolf() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(WolfBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "wolf character";
    }
}
