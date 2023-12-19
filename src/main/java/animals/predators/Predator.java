package main.java.animals.predators;

import main.java.animals.AbstractAnimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class Predator extends AbstractAnimal {

    protected Predator(String cost) {
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
    }

}
