package animals.utils;

import animals.AbstractAnimal;

public class ValidationUtils {
    public static boolean validateAnimal(Object[] array) {
        for (Object obj : array) {
            if (!(obj instanceof AbstractAnimal)) return false;
        }
        return true;
    }
}
