package main.java.animals.pets;

import main.java.animals.enums.AnimalNames;
import main.java.animals.enums.RandomEnumGenerator;
import main.java.animals.enums.breeds.DogBreeds;
import main.java.animals.utils.RandomUtils;


public class Dog extends Pet {
    public Dog() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(DogBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "dog character";
    }
}
