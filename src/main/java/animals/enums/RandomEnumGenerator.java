package main.java.animals.enums;

import java.util.Random;

public class RandomEnumGenerator {
    public static <T extends Enum<?>> T getRandom(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }
}
