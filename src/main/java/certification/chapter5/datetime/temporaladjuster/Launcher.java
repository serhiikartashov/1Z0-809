package certification.chapter5.datetime.temporaladjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        // standard adjusters
        adjusters();
        System.out.println();
        // thanks giving
        thanksgiving(2015);
        thanksgiving(2016);
        thanksgiving(2017);
        System.out.println();
        // louvre free payment days
        louvreFreeDaysInYear(2015);
        louvreFreeDaysInYear(2016);
        louvreFreeDaysInYear(2017);
        // the day of programmer
        programmersDay(2015);
        programmersDay(2016);
        programmersDay(2017);
        System.out.println();
        // the president day in USA
        presidentDay(2015);
        presidentDay(2016);
        presidentDay(2017);
        System.out.println();
        // custom adjuster
        customAdjuster();

        // next() nextOrSame() previous() previousOrSame()

    }

    private static void adjusters() {
        LocalDate date = LocalDate.of(2015, Month.OCTOBER, 14);
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n", date, dotw);

        System.out.printf("first day of Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("first Monday of Month: %s%n",
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("last day of Month: %s%n",
                date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("first day of next Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("first day of next Year: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("first day of Year: %s%n",
                date.with(TemporalAdjusters.firstDayOfYear()));

    }

    private static void thanksgiving(int year) {
        LocalDate thanksGiving = Year.of(year).atMonth(Month.NOVEMBER).atDay(1)
                .with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        LocalDate thanksGiving4 = Year.of(year).atMonth(Month.NOVEMBER).atDay(1)
                .with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
        // the last Thursday in November
        System.out.println("ThanksGiving: " + thanksGiving);
        // the 4th Thursday in November
        System.out.println("ThanksGiving: " + thanksGiving4);
    }

    private static void louvreFreeDaysInYear(int year) {
        // the first week of month

    }

    // custom!
    private static void programmersDay(int year) {
        // on the 256th day
        LocalDate programmersDay = Year.of(year).atMonth(1).atDay(1).
                with(ChronoField.DAY_OF_YEAR, 256);
        // LocalDate programmersDay = LocalDate.of(year, 1, 1).plusDays(256);
        System.out.println("Programmer's Day: " + programmersDay);
    }

    private static void presidentDay(int year) {
        // the first Monday Of February
        LocalDate presidentsDay = Year.of(year).atMonth(Month.FEBRUARY).atDay(1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("President's day (USA): " + presidentsDay);
    }

    private static void customAdjuster() {
        LocalDate october_13 = LocalDate.of(2015, Month.OCTOBER, 13);
        LocalDate nextPayday1 = october_13.with(new PaydayAdjuster());
        System.out.println("Given the date:  " + october_13);
        System.out.println("the next payday: " + nextPayday1);

        LocalDate october_18 = LocalDate.of(2015, Month.OCTOBER, 18);
        LocalDate nextPayday2 = october_18.with(new PaydayAdjuster());
        System.out.println("Given the date:  " + october_18);
        System.out.println("the next payday: " + nextPayday2);
    }
}
