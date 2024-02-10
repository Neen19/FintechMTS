package ru.mtsbank.demofintech.animals.predators;

import ru.mtsbank.demofintech.animals.enums.AnimalNames;
import ru.mtsbank.demofintech.animals.enums.RandomEnumGenerator;
import ru.mtsbank.demofintech.animals.enums.breeds.WolfBreeds;
import ru.mtsbank.demofintech.animals.utils.RandomUtils;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(WolfBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "wolf character";
    }

    public Wolf(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
