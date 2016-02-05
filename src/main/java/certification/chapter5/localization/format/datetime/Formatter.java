package certification.chapter5.localization.format.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by Serhii K. on 12/1/2015.
 */
public class Formatter {

    // more info here:
    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#predefined

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        System.out.println(text);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate);

        predefinedFormatters();
    }

    private static void predefinedFormatters() {
        LocalDate ld1 = LocalDate.now();
        //Locale.setDefault(new Locale("uk"));
        String ld1_f1 = ld1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String ld1_f2 = ld1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String ld1_f3 = ld1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        String ld1_f4 = ld1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(ld1_f1);
        System.out.println(ld1_f2);
        System.out.println(ld1_f3);
        System.out.println(ld1_f4);

        LocalTime lt1 = LocalTime.now();
        //String lt1_f1 = lt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG));
        //String lt1_f2 = lt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL));
        String lt1_f3 = lt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        String lt1_f4 = lt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        System.out.println(lt1_f3);
        System.out.println(lt1_f4);

        LocalDateTime ldt1 = LocalDateTime.now();
        //String ldt1_f1 = ld1.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        //String ldt1_f2 = ld1.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        //String ldt1_f3 = ld1.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        //String ldt1_f4 = ld1.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        //System.out.println(ldt1_f1);
        //System.out.println(ldt1_f2);
        //System.out.println(ldt1_f3);
        //System.out.println(ldt1_f4);

        DateTimeFormatter fb_1 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("uk"))
                        .withZone(ZoneId.of("Europe/Kiev"));
        formatDateTime(ldt1, fb_1);
        DateTimeFormatter fb_2 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("ru"))
                        .withZone(ZoneId.of("Europe/Moscow"));
        formatDateTime(ldt1, fb_2);
        DateTimeFormatter fb_3 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("ja"))
                        .withZone(ZoneId.of("Asia/Tokyo"));
        formatDateTime(ldt1, fb_3);
        DateTimeFormatter fb_4 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("hi", "IN"))
                        .withZone(ZoneId.of("Indian/Kerguelen"));
        formatDateTime(ldt1, fb_4);
        DateTimeFormatter fb_5 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("fr"))
                        .withZone(ZoneId.of("Europe/Paris"));
        formatDateTime(ldt1, fb_5);
        DateTimeFormatter fb_6 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("de"))
                        .withZone(ZoneId.of("Europe/Berlin"));
        formatDateTime(ldt1, fb_6);
        DateTimeFormatter fb_7 =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(new Locale("hi", "IN"))
                        .withZone(ZoneId.of("Europe/Berlin"))
                        .withDecimalStyle(DecimalStyle.of(new Locale("uk")));
        formatDateTime(ldt1, fb_7);
        // Indian/Kerguelen - hi
        /*ZoneId.getAvailableZoneIds().forEach(System.out::println);
        List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());

        for (Locale locale : locales) {
            System.out.println(locale);
            System.out.println(locale.getDisplayName());
        }*/

        // predefined
        formatDateTime(ldt1, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        formatDateTime(ldt1, DateTimeFormatter.ISO_ORDINAL_DATE);
        formatDateTime(ldt1, DateTimeFormatter.ISO_WEEK_DATE);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        formatDateTimeZ(zonedDateTime, DateTimeFormatter.RFC_1123_DATE_TIME);

    }

    private static void formatDateTime(LocalDateTime ldt1, DateTimeFormatter fb_1) {
        String ldt1_f2 = ldt1.format(fb_1);
        System.out.println(ldt1_f2);
    }
    private static void formatDateTimeZ(ZonedDateTime ldt1, DateTimeFormatter fb_1) {
        String ldt1_f2 = ldt1.format(fb_1);
        System.out.println(ldt1_f2);
    }


}
