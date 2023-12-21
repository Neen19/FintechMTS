package main.java.animals.utils;

import java.util.Random;

public class RandomUtils {
    public static final Random random = new Random();

    public static String genPrice() {
        return String.valueOf(random.nextDouble(10000D));
    }

    public static int genRandomInt(int bound) {
        return random.nextInt(bound);
    }
}
