package ru.mtsbank.demofintech.animals.enums;


import ru.mtsbank.demofintech.animals.utils.RandomUtils;

public class RandomEnumGenerator {
    public static <T extends Enum<?>> T getRandom(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        return values[RandomUtils.genRandomInt(values.length)];
    }
}
