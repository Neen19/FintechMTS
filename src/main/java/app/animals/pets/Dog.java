package app.animals.pets;

import app.animals.enums.AnimalNames;
import app.animals.enums.RandomEnumGenerator;
import app.animals.enums.breeds.DogBreeds;
import app.animals.utils.RandomUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(DogBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "dog character";
    }

    public Dog(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
