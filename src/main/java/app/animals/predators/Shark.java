package app.animals.predators;

import app.animals.enums.AnimalNames;
import app.animals.enums.RandomEnumGenerator;
import app.animals.enums.breeds.SharkBreeds;
import app.animals.utils.RandomUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;



public class Shark extends Predator {

    public Shark() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(SharkBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "shark character";
    }

    public Shark(String breed, String name, double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
