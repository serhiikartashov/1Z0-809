package certification.localization.format.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by Serhii K. on 12/1/2015.
 */
public class DisplayInfo {

    public static void main(String[] args) {
        partialAndInformation();
    }

    public static void partialAndInformation() {

        LocalDate date = LocalDate.of(2015, Month.FEBRUARY, 15); // 2014-02-15
        Month february = date.getMonth();
        february.getValue(); // = 2
        System.out.println(date);

        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

        date.getYear(); // 2014
        date.getDayOfYear(); // 46

        Year year_2014 = Year.of(2014);
        year_2014.isLeap(); // false

        DayOfWeek dayOfWeek = date.getDayOfWeek(); // SATURDAY

        dayOfWeek = DayOfWeek.FRIDAY;
        displayDayOfWeek(dayOfWeek, Locale.FRENCH);
        displayDayOfWeek(dayOfWeek, Locale.CHINESE);
        displayDayOfWeek(dayOfWeek, new Locale("uk"));
        displayDayOfWeek(dayOfWeek, Locale.getDefault());
        displayMonth(february, Locale.FRENCH);
        displayMonth(february, Locale.CHINESE);
        displayMonth(february, new Locale("uk"));
        displayMonth(february, Locale.getDefault());
        displayMonth(february, Locale.getDefault(Locale.Category.FORMAT));
        displayMonth(february, Locale.getDefault(Locale.Category.DISPLAY));

    }

    private static void displayDayOfWeek(DayOfWeek dayOfWeek, Locale locale) {
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, locale)); // Friday
        System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, locale)); // F
        System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, locale)); // Fri
    }

    private static void displayMonth(Month month, Locale locale) {
        System.out.println(month.getDisplayName(TextStyle.FULL, locale)); // Friday
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale)); // F
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale)); // Fri
    }
}
