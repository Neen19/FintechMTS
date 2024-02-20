package app.animals.pets;

import app.animals.enums.AnimalNames;
import app.animals.enums.RandomEnumGenerator;
import app.animals.enums.breeds.CatBreeds;
import app.animals.utils.RandomUtils;

import java.time.LocalDate;


public class Cat extends Pet {
    public Cat() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(CatBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "cat character";
    }

    public Cat(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
