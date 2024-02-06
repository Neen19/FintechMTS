package animals.pets;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.CatBreeds;
import animals.utils.RandomUtils;

import java.math.BigDecimal;
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
