package revise;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class DateTimeApiExample {

    public static void main(String[] args) {

        // ==========================================
        // 1. LocalDate (Date only: yyyy-MM-dd)
        // ==========================================
        LocalDate today = LocalDate.now(); // Current system date
        LocalDate specificDate = LocalDate.of(2026, 8, 21); // Specific date
        LocalDate nextWeek = today.plusWeeks(1); // Immutable modification

        System.out.println("--- LocalDate Examples ---");
        System.out.println("Today: " + today);
        System.out.println("Specific Date: " + specificDate);
        System.out.println("Next Week: " + nextWeek);
        System.out.println("Is Leap Year? " + today.isLeapYear());

        // ==========================================
        // 2. LocalTime (Time only: HH:mm:ss.nnn)
        // ==========================================
        LocalTime now = LocalTime.now(); // Current system time
        LocalTime specificTime = LocalTime.of(14, 30, 0); // 14:30:00
        LocalTime advancedTime = now.plusHours(2);

        System.out.println("\n--- LocalTime Examples ---");
        System.out.println("Current Time: " + now);
        System.out.println("Specific Time: " + specificTime);
        System.out.println("Time in 2 Hours: " + advancedTime);

        // ==========================================
        // 3. LocalDateTime (Combines Date & Time)
        // ==========================================
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime customizedDateTime = LocalDateTime.of(specificDate, specificTime);

        System.out.println("\n--- LocalDateTime Examples ---");
        System.out.println("Current Date-Time: " + currentDateTime);
        System.out.println("Customized Date-Time: " + customizedDateTime);

        // ==========================================
        // 4. ZonedDateTime (Date-Time with Time Zones)
        // ==========================================
        ZonedDateTime systemZoneTime = ZonedDateTime.now(); // Default zone
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        System.out.println("\n--- ZonedDateTime Examples ---");
        System.out.println("Local ZonedDateTime: " + systemZoneTime);
        System.out.println("Current Time in Tokyo: " + tokyoTime);

        // ==========================================
        // 5. Period (Date-based differences: Years/Months/Days)
        // ==========================================
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 8, 21);
        Period period = Period.between(startDate, endDate);

        System.out.println("\n--- Period Examples ---");
        System.out.println("Difference: " + period.getYears() + " years, "
                + period.getMonths() + " months, "
                + period.getDays() + " days");

        // ==========================================
        // 6. Duration (Time-based differences: Seconds/Nanos)
        // ==========================================
        LocalTime start = LocalTime.of(9, 0, 0);
        LocalTime end = LocalTime.of(17, 30, 0);
        Duration duration = Duration.between(start, end);

        System.out.println("\n--- Duration Examples ---");
        System.out.println("Workday duration in minutes: " + duration.toMinutes());
        System.out.println("Workday duration in hours: " + duration.toHours());

        // ==========================================
        // 7. DateTimeFormatter (Formatting and Parsing)
        // ==========================================
        LocalDateTime dateTimeToFormat = LocalDateTime.of(2026, 8, 21, 16, 45);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Formatting: Object -> String
        String formattedString = dateTimeToFormat.format(formatter);
        // Parsing: String -> Object
        LocalDateTime parsedDateTime = LocalDateTime.parse("21-08-2026 16:45", formatter);

        System.out.println("\n--- DateTimeFormatter Examples ---");
        System.out.println("Formatted String: " + formattedString);
        System.out.println("Parsed LocalDateTime: " + parsedDateTime);
    }
}
