package animals.pets;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.DogBreeds;
import animals.utils.RandomUtils;

import java.math.BigDecimal;
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
