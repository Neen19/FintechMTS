package ru.mtsbank.demofintech.animals.pets;

import ru.mtsbank.demofintech.animals.enums.AnimalNames;
import ru.mtsbank.demofintech.animals.enums.RandomEnumGenerator;
import ru.mtsbank.demofintech.animals.enums.breeds.CatBreeds;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.time.LocalDate;


public class Cat extends Pet {
    public Cat(String name) {
        super(name);
        this.breed = RandomEnumGenerator.getRandom(CatBreeds.class).toString();
        this.character = "cat character";
    }

    public Cat(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
