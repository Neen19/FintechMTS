package main.java.animals.utils;

import java.util.Random;

public class RandomUtils {
    public final static Random random = new Random();

    public static String genPrice() {
        return String.valueOf(random.nextDouble(10000D));
    }
}
