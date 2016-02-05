package certification.chapter5.datetime.date;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {

        // Receiving current date/time
        System.out.println(LocalDate.now());        // 2015-10-12
        System.out.println(LocalTime.now());        // 15:32:20.908
        // Java uses T to separate the date and time when converting
        // LocalDateTime to a String
        System.out.println(LocalDateTime.now());    // 2015-10-12T15:32:20.908

        // LocalDate  Contains just a date—no time and no time zone.
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);
        System.out.println(date1);                  // 2015-01-20
        System.out.println(date2);                  // 2015-01-20
        // LocalDate d = new LocalDate(); // does not compile - private constructor
        // LocalDate.of(2015, Month.JANUARY, 32);     // throws DateTimeException

        // LocalTime   Contains just a time—no date and no time zone.
        LocalTime time1 =  LocalTime.of(6, 15);             // hour and minute
        LocalTime time2 =  LocalTime.of(6, 15, 30);         // + seconds
        LocalTime time3 =  LocalTime.of(6, 15, 30, 200);    // + nanoseconds
        System.out.println(time1);                  // 06:15
        System.out.println(time2);                  // 06:15:30
        System.out.println(time3);                  // 06:15:30.000000200
        LocalTime trancatedTime1 = time3.truncatedTo(ChronoUnit.SECONDS);
        System.out.println(trancatedTime1);          // 06:15:30
        LocalTime trancatedTime2 = time3.truncatedTo(ChronoUnit.HOURS);
        System.out.println(trancatedTime2);          // 06:00

        // LocalDateTime  Contains both a date and time but no time zone.
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
        System.out.println(dateTime1);              // 2015-01-20T06:15:30
        System.out.println(dateTime2);              // 2015-01-20T06:15


        // YearMonth
        YearMonth yearMonth1 = YearMonth.now();
        System.out.printf("%s: %d%n", yearMonth1, yearMonth1.lengthOfMonth());  // 2015-10: 31

        YearMonth yearMonth2 = YearMonth.of(2010, Month.FEBRUARY);
        System.out.printf("%s: %d%n", yearMonth2, yearMonth2.lengthOfMonth());  // 2010-02: 28

        YearMonth yearMonth3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", yearMonth3, yearMonth3.lengthOfMonth());  // 2012-02: 29

        // MonthDay
        MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = date.isValidYear(2010);
        System.out.println(validLeapYear);          // false
        System.out.println(date.range(ChronoField.MONTH_OF_YEAR));

        // Year
        boolean validLeapYear1 = Year.of(2012).isLeap();
        System.out.println(validLeapYear1);         // true

        Year year = Year.of(2012);
        System.out.println(year.range(ChronoField.YEAR));

        boolean isSupported1 = LocalDate.now().isSupported(ChronoField.CLOCK_HOUR_OF_DAY); // false
        Instant instant = Instant.now();
        boolean isSupported2 = instant.isSupported(ChronoUnit.DAYS);    // false

    }
}
