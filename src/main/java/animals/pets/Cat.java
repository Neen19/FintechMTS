package animals.pets;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.CatBreeds;
import animals.utils.RandomUtils;


public class Cat extends Pet {
    public Cat() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(CatBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "cat character";
    }
}
