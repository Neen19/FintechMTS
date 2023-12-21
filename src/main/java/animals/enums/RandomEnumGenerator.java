package main.java.animals.enums;

import main.java.animals.utils.RandomUtils;

import java.util.Random;

public class RandomEnumGenerator {
    public static <T extends Enum<?>> T getRandom(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        return values[RandomUtils.random.nextInt(values.length)];
    }
}
