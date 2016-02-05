package certification.chapter5.localization.format;

import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;

/**
 * Created by Serhii K. on 11/25/2015.
 */
public class ICU4J {

    public static void main(String[] args) {
        ULocale germanLocale = ULocale.forLanguageTag("de-DE");
        ULocale usLocale = ULocale.forLanguageTag("en-US");
        ULocale jpLocale = ULocale.forLanguageTag("ja-JP");
        ULocale ukLocale = ULocale.forLanguageTag("uk-UKR");

        showExemplarCharacterSets(germanLocale);
        showExemplarCharacterSets(usLocale);
        showExemplarCharacterSets(jpLocale);
        showExemplarCharacterSets(ukLocale);
        showDistance(germanLocale);
        showDistance(usLocale);
        showDistance(jpLocale);
        showPaperSize(germanLocale);
        showPaperSize(usLocale);
        showPaperSize(jpLocale);

        System.out.println(NumberFormat.getCurrencyInstance(jpLocale).format(1212121212));
        System.out.println(NumberFormat.getCurrencyInstance(ukLocale).format(1212121212));

        ULocale[] locales = ULocale.getAvailableLocales();
        for (ULocale uLocale :locales) {
            System.out.println(NumberFormat.getCurrencyInstance(uLocale).format(1212121212));
        }

    }

    private static void showExemplarCharacterSets(ULocale locale) {
        printSet("Standard:",
                LocaleData.getExemplarSet(locale, LocaleData.ES_STANDARD));
        printSet("Index chars:",
                LocaleData.getExemplarSet(locale, LocaleData.ES_INDEX));
        printSet("Auxiliary:",
                LocaleData.getExemplarSet(locale, LocaleData.ES_AUXILIARY));
        printSet("Punctuation:",
                LocaleData.getExemplarSet(locale, LocaleData.ES_PUNCTUATION));
    }

    private static void printSet(String name, UnicodeSet set) {
        System.out.print(name);
        for (String s : set) {
            System.out.print(" ");
            System.out.print(s);
        }
        System.out.println();
    }

    private static void showDistance(ULocale locale) {
        int distance = 160;
        LocaleData.MeasurementSystem system = LocaleData.getMeasurementSystem(locale);
        String unit;
        if (system.equals(LocaleData.MeasurementSystem.SI)) {
            unit = "km";
        } else if (system.equals(LocaleData.MeasurementSystem.US)) {
            unit = "mi";
            distance = (int) (distance / 1.6);
        } else {
            throw new RuntimeException("Unknown measurement system.");
        }
        String distanceMessage = MessageFormat.format(
                "The distance between cities is {0} {1}.", distance, unit);
        System.out.println(distanceMessage);
    }

    private static void showPaperSize(ULocale locale) {
        LocaleData.PaperSize paperSize = LocaleData.getPaperSize(locale);
        String msg = MessageFormat.format("The paper size is: {0}x{1} mm",
                paperSize.getWidth(), paperSize.getHeight());
        System.out.println(msg);
    }
}
