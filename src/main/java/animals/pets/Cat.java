package main.java.animals.pets;

import main.java.animals.enums.AnimalNames;
import main.java.animals.enums.RandomEnumGenerator;
import main.java.animals.enums.breeds.CatBreeds;
import main.java.animals.utils.RandomUtils;


public class Cat extends Pet {
    public Cat() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(CatBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "cat character";
    }
}
