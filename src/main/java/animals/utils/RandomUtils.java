package animals.utils;

import animals.AbstractAnimal;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static <T>  T genRandomClass(List<Class<? extends T>> classes) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        int index = RandomUtils.genRandomInt(classes.size());
        return classes.get(index).getDeclaredConstructor().newInstance();
    }

    public static LocalDate genRandomDate() {
        int year = random.nextInt(2023 - 1970 + 1) + 1970;
        int month = random.nextInt(12) + 1;
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = random.nextInt(maxDay) + 1;

        return LocalDate.of(year, month, day);
    }

}
