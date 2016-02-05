package certification.chapter5.datetime.calendars;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.util.Locale;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class ChronoLauncher {

    public static void main(String[] args) {
        Year year1 = Year.now();
        Year year2 = Year.of(2012);
        System.out.println(IsoChronology.INSTANCE.isLeapYear(year1.getValue()));
        System.out.println(IsoChronology.INSTANCE.isLeapYear(year2.getValue()));


        TemporalQuery<Chronology> chronology = TemporalQueries.chronology();
        System.out.println(LocalDate.now().query(chronology));   // ISO
        System.out.println();

        convertingToNonISOBasedDate();
        convert1();
        convert2();
    }

    private static void convertingToNonISOBasedDate(){
        LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        // they extended from ChronoLocalDateImpl
        JapaneseDate jdate     = JapaneseDate.from(date);
        System.out.println(jdate);              // Japanese Heisei 25-07-20
        HijrahDate hdate       = HijrahDate.from(date);
        System.out.println(hdate);              // Hijrah-umalqura AH 1434-09-12
        MinguoDate mdate       = MinguoDate.from(date);
        System.out.println(mdate);              // Minguo ROC 102-07-20
        ThaiBuddhistDate tdate = ThaiBuddhistDate.from(date);
        System.out.println(tdate);              // ThaiBuddhist BE 2556-07-20
    }

    private static void convert1(){
        LocalDate date = LocalDate.of(1996, Month.OCTOBER, 29);
        System.out.printf("%s%n",
                ChronoLauncher.toString(date, JapaneseChronology.INSTANCE));      // H8.10.29
        System.out.printf("%s%n",
                ChronoLauncher.toString(date, MinguoChronology.INSTANCE));        // 1 085-10-29
        System.out.printf("%s%n",
                ChronoLauncher.toString(date, ThaiBuddhistChronology.INSTANCE));  // B.E. 2539-10-29
        System.out.printf("%s%n",
                ChronoLauncher.toString(date, HijrahChronology.INSTANCE));        // 6/16/17 AH
    }

    private static void convert2(){
        System.out.printf("%s%n", ChronoLauncher.fromString("10/29/0008 H",
                JapaneseChronology.INSTANCE));
        System.out.printf("%s%n", ChronoLauncher.fromString("10/29/0085 1",
                MinguoChronology.INSTANCE));
        System.out.printf("%s%n", ChronoLauncher.fromString("10/29/2539 B.E.",
                ThaiBuddhistChronology.INSTANCE));
        System.out.printf("%s%n", ChronoLauncher.fromString("6/16/1417 1",
                HijrahChronology.INSTANCE));
    }


    /**
     * Converts a LocalDate (ISO) value to a ChronoLocalDate date
     * using the provided Chronology, and then formats the
     * ChronoLocalDate to a String using a DateTimeFormatter with a
     * SHORT pattern based on the Chronology and the current Locale.
     *
     * @param localDate - the ISO date to convert and format.
     * @param chrono - an optional Chronology. If null, then IsoChronology is used.
     */
    public static String toString(LocalDate localDate, Chronology chrono) {
        if (localDate != null) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            ChronoLocalDate cDate;
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            try {
                cDate = chrono.date(localDate);
            } catch (DateTimeException ex) {
                System.err.println(ex);
                chrono = IsoChronology.INSTANCE;
                cDate = localDate;
            }
            String pattern = "M/d/yyyy GGGGG";
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.
                            ofLocalizedDate(FormatStyle.SHORT) // use another style without pattern
                            .ofPattern(pattern) // comment this to see the difference!
                            .withLocale(locale)
                            .withChronology(chrono)
                            .withDecimalStyle(DecimalStyle.of(locale));
            return dateFormatter.format(cDate);
        } else {
            return "";
        }
    }


    /**
     * Parses a String to a ChronoLocalDate using a DateTimeFormatter
     * with a short pattern based on the current Locale and the
     * provided Chronology, then converts this to a LocalDate (ISO)
     * value.
     *
     * @param text   - the input date text in the SHORT format expected
     *                 for the Chronology and the current Locale.
     *
     * @param chrono - an optional Chronology. If null, then IsoChronology
     *                 is used.
     */
    public static LocalDate fromString(String text, Chronology chrono) {
        if (text != null && !text.isEmpty()) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            String pattern = "M/d/yyyy GGGGG";
            DateTimeFormatter df = new DateTimeFormatterBuilder()
                    .parseLenient()
                    .appendPattern(pattern)
                    .toFormatter()
                    .withChronology(chrono)
                    .withDecimalStyle(DecimalStyle.of(locale));
            TemporalAccessor temporal = df.parse(text);
            ChronoLocalDate cDate = chrono.date(temporal);
            return LocalDate.from(cDate);
        }
        return null;
    }
}
