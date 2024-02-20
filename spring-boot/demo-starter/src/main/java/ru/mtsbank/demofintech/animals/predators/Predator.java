package ru.mtsbank.demofintech.animals.predators;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.time.LocalDate;

public class Predator extends AbstractAnimal {

    protected Predator(String name) {
        super(name);
    }

    protected Predator(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
