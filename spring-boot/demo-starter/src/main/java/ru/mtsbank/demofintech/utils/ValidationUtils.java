package ru.mtsbank.demofintech.utils;

import java.util.List;

public class ValidationUtils {
    public static<T> boolean validateListOfClass(List<T> objs, Class<?> cl) {
        for (Object obj : objs) {
            if (!cl.isInstance(obj)) return false;
        }
        return true;
    }
}
