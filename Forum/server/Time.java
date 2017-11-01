package server;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getFormattedDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy MMMM dd");
        String formattedDate = localDate.format(formatDate);

        return formattedDate;
    }

    public static String getFormattedTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String formattedTime = localTime.format(formatTime);

        return formattedTime;
    }
}
