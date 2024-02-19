package ru.mtsbank.demofintech.animals.predators;

import ru.mtsbank.demofintech.animals.enums.AnimalNames;
import ru.mtsbank.demofintech.animals.enums.RandomEnumGenerator;
import ru.mtsbank.demofintech.animals.enums.breeds.SharkBreeds;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.time.LocalDate;



public class Shark extends Predator {

    public Shark(String name) {
        super(name);
        this.breed = RandomEnumGenerator.getRandom(SharkBreeds.class).toString();
        this.character = "shark character";
    }

    public Shark(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
