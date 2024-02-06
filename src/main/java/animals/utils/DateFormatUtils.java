package animals.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String formatDate(LocalDate date) {
        return date.format(formatter);
    }

    public static int LocalDateToDays(LocalDate date) {
        return date.getYear() * 365 + date.getDayOfYear();
    }
}
