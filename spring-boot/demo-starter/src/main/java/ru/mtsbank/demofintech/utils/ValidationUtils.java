package ru.mtsbank.demofintech.utils;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.util.List;

public class ValidationUtils {
    public static<T> boolean validateAnimal(List<T> objs) {
        for (Object obj : objs) {
            if (!(obj instanceof AbstractAnimal)) return false;
        }
        return true;
    }
}
