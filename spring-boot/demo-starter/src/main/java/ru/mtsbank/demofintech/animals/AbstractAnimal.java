package ru.mtsbank.demofintech.animals;

import ru.mtsbank.demofintech.animals.utils.DateFormatUtils;
import ru.mtsbank.demofintech.animals.utils.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;


public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;

    protected LocalDate birthDate;

    protected AbstractAnimal(String cost) {
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
        birthDate = RandomUtils.genRandomDate();
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

    public AbstractAnimal(String breed, String name, double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {

        return "breed: " + this.breed + "\n" +
                "name: " + this.name + "\n" +
                "cost: " + this.cost + "\n" +
                "character: " + this.character + "\n" +
                "birthDate: " + DateFormatUtils.formatDate(this.birthDate) + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj.getClass() != this.getClass()) return false;
        AbstractAnimal other = (AbstractAnimal) obj;
        return (other.breed.equals(this.breed) &&
                other.name.equals(this.name) &&
                other.character.equals(this.character) &&
                other.cost.equals(this.cost) &&
                other.birthDate.equals(this.birthDate)
        );
    }
}
