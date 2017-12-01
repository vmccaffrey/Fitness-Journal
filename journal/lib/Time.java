package lib;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getFormattedDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return localDate.format(formatDate);
    }

    public static String getFormattedTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss a");

        return localTime.format(formatTime);
    }

    public static String formatTimer() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        return localTime.format(formatTime);
    }
}
