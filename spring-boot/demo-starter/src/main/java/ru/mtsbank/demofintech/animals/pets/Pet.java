package ru.mtsbank.demofintech.animals.pets;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.time.LocalDate;

public class Pet extends AbstractAnimal {
    protected Pet(String cost) {
        super(cost);
    }

    protected Pet(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
