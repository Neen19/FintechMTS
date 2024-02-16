package ru.mtsbank.demofintech.animals.utils;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

public class ValidationUtils {
    public static boolean validateAnimal(Object[] array) {
        for (Object obj : array) {
            if (!(obj instanceof AbstractAnimal)) return false;
        }
        return true;
    }
}
