package main.java.animals.predators;

import main.java.animals.enums.AnimalNames;
import main.java.animals.enums.RandomEnumGenerator;
import main.java.animals.enums.breeds.SharkBreeds;

import java.util.Random;

public class Shark extends Predator {

    public Shark() {
        super(String.valueOf(new Random().nextDouble(10000D)));
        this.breed = RandomEnumGenerator.getRandom(SharkBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "shark character";
    }
}
