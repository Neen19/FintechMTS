package animals.predators;

import animals.enums.AnimalNames;
import animals.enums.RandomEnumGenerator;
import animals.enums.breeds.WolfBreeds;
import animals.utils.RandomUtils;


public class Wolf extends Predator {
    public Wolf() {
        super(RandomUtils.genPrice());
        this.breed = RandomEnumGenerator.getRandom(WolfBreeds.class).toString();
        this.name = RandomEnumGenerator.getRandom(AnimalNames.class).toString();
        this.character = "wolf character";
    }
}
