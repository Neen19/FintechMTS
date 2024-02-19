package ru.mtsbank.demofintech.utils;

import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.pets.Dog;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static String genPrice() {
        return String.valueOf(random.nextDouble());
    }

    public static int genRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public static <T>  T genRandomClass(Class<? extends T> animalType, String[] names) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        return animalType.getDeclaredConstructor(String.class).newInstance(getRandomFromArray(names));
    }

    public static LocalDate genRandomDate() {
        int year = random.nextInt(2023 - 1970 + 1) + 1970;
        int month = random.nextInt(12) + 1;
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = random.nextInt(maxDay) + 1;

        return LocalDate.of(year, month, day);
    }


    private static<T> T getRandomFromArray(T[] array) {
        int len = array.length;
        return array[random.nextInt(len - 1)];
    }

}
