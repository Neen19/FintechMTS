package animals.predators;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.SharkBreeds;
import animals.utils.RandomUtils;

public class Shark extends Predator {

    public Shark() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(SharkBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "shark character";
    }
}
