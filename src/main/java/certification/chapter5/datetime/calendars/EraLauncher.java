package certification.chapter5.datetime.calendars;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Arrays;

/**
 * Created by Serhii on 13.10.2015.
 */
public class EraLauncher {

    public static void main(String[] args) {

        System.out.println(Arrays.asList(JapaneseEra.values()));

        System.out.println(JapaneseChronology.INSTANCE.eraOf(-1));
        System.out.println(JapaneseChronology.INSTANCE.eraOf(0));
        System.out.println(JapaneseChronology.INSTANCE.eraOf(1));
        System.out.println(JapaneseChronology.INSTANCE.eraOf(2));
        System.out.println();

        // getEra(LocalDate.of(1872, 2, 2)); BUG!  JDK-8123460
        // The singleton instance for the 'Meiji' era (1868-01-01 - 1912-07-29)
        getEra(LocalDate.of(1873, 2, 2));
        getEra(LocalDate.of(1888, 1, 1));
        getEra(LocalDate.of(1920, 1, 1));
        getEra(LocalDate.of(1988, 1, 1));
        getEra(LocalDate.of(1989, 1, 8));
        getEra(LocalDate.of(2015, 10, 13));

        ValueRange valueRange = JapaneseChronology.INSTANCE.eraOf(1).range(ChronoField.ERA);
        System.out.println(valueRange);

    }

    private static void getEra(LocalDate localDate){
        JapaneseChronology japaneseChronology = JapaneseChronology.INSTANCE;
        ChronoLocalDate chronoLocalDate = japaneseChronology.date(localDate);
        System.out.println(localDate + " rom Era: " + chronoLocalDate.getEra());
    }
}
