package animals.pets;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.DogBreeds;
import animals.utils.RandomUtils;


public class Dog extends Pet {
    public Dog() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(DogBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "dog character";
    }
}
