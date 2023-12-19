package main.java.animals.predators;

import main.java.animals.enums.AnimalNames;
import main.java.animals.enums.RandomEnumGenerator;
import main.java.animals.enums.breeds.WolfBreeds;

import java.util.Random;

public class Wolf extends Predator {
    public Wolf() {
        super(String.valueOf(new Random().nextDouble(10000D)));
        this.breed = RandomEnumGenerator.getRandom(WolfBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "wolf character";
    }
}
