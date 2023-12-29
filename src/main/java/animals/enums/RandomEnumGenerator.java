package animals.enums;

import animals.utils.RandomUtils;


public class RandomEnumGenerator {
    public static <T extends Enum<?>> T getRandom(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        return values[RandomUtils.genRandomInt(values.length)];
    }
}
