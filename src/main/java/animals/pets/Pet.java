package main.java.animals.pets;

import main.java.animals.AbstractAnimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

abstract public class Pet extends AbstractAnimal {
    protected Pet(String cost) {
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
    }

}
