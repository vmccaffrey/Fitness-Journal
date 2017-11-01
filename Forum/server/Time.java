<<<<<<< HEAD
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
=======
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
>>>>>>> d668070edece6b6733ef33dc1935fb274d3261df
