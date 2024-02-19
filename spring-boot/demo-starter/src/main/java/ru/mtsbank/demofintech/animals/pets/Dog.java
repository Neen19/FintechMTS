package ru.mtsbank.demofintech.animals.pets;

import ru.mtsbank.demofintech.animals.enums.AnimalNames;
import ru.mtsbank.demofintech.animals.enums.RandomEnumGenerator;
import ru.mtsbank.demofintech.animals.enums.breeds.DogBreeds;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
        this.breed = RandomEnumGenerator.getRandom(DogBreeds.class).toString();
        this.character = "dog character";
    }

    public Dog(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
