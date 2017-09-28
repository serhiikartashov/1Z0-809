package certification.chapter5.localization.format;

import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/25/2015.
 */
public class ICU4J {

    public static void main(String[] args) {
//        ULocale germanLocale = ULocale.forLanguageTag("de-DE");
        ULocale usLocale = ULocale.forLanguageTag("en-US");
//        ULocale jpLocale = ULocale.forLanguageTag("ja-JP");
//        ULocale ukLocale = ULocale.forLanguageTag("uk-UKR");
//
//        ULocale araLocale = ULocale.forLanguageTag("ara-AE");
//
//        System.out.println("uk1: " + araLocale.getDisplayLanguage(usLocale));
//        System.out.println("uk1: " + araLocale.getDisplayLanguage(araLocale));
//        System.out.println("jp1: " + jpLocale.getDisplayLanguage(usLocale));
//        System.out.println("jp2: " + jpLocale.getDisplayLanguage(jpLocale));
//        System.out.println("ge1: " + germanLocale.getDisplayLanguage(usLocale));
//        System.out.println("ge2: " + germanLocale.getDisplayLanguage(germanLocale));

        Locale javaEnLocale = Locale.forLanguageTag("eng-US");
        Locale javaAraLocale = Locale.forLanguageTag("ara-AE");
        Locale defaultLocale = Locale.getDefault(Locale.Category.DISPLAY);

        System.out.println("def: " + javaAraLocale.getDisplayLanguage(defaultLocale));
        System.out.println("eng: " + javaAraLocale.getDisplayLanguage(javaEnLocale));
        System.out.println("ara: " + javaAraLocale.getDisplayLanguage(javaAraLocale));
        System.out.println("List: \n");
        /*Locale[] locales = Locale.getAvailableLocales();
        System.out.println(locales.length);
        for (int i = 0; i < locales.length; i++) {
            if (!locales[i].getCountry().isEmpty()) {
                System.out.println(i + ". " + locales[i].getISO3Language() + "-" + locales[i].getCountry());
                System.out.println(i + ". " + "eng: " + locales[i].getDisplayLanguage(javaEnLocale));
                System.out.println(i + ". " + "localized: " + locales[i].getDisplayLanguage(locales[i]));
            }
        }*/

        ULocale[] ulocales = ULocale.getAvailableLocales();
        System.out.println(ulocales.length);
        int j = 1;
        for (int i = 0; i < ulocales.length; i++) {
            if (!ulocales[i].getCountry().isEmpty() && !ulocales[i].getISO3Language().isEmpty()) {

                // insert into lang_name (id, lang_code, lang_name, lang_name_locale) values (1, 'lit-LT', 'Lithuanian', 'lietuvių');
                System.out.print("insert into lang_name (id, lang_code, lang_name, lang_name_locale) values (" +
                        j + ", '" + ulocales[i].getISO3Language() + "-" + ulocales[i].getCountry() + "', ");
                System.out.print("'" + ulocales[i].getDisplayLanguage(usLocale) + "', ");
                System.out.println("'" + ulocales[i].getDisplayLanguage(ulocales[i]) + "');");
                j++;
//                System.out.println(ulocales[i].getDisplayCountry());
            }
        }


//        showExemplarCharacterSets(germanLocale);
//        showExemplarCharacterSets(usLocale);
//        showExemplarCharacterSets(jpLocale);
//        showExemplarCharacterSets(ukLocale);
//        showDistance(germanLocale);
//        showDistance(usLocale);
//        showDistance(jpLocale);
//        showPaperSize(germanLocale);
//        showPaperSize(usLocale);
//        showPaperSize(jpLocale);
//
//        System.out.println(NumberFormat.getCurrencyInstance(jpLocale).format(1212121212));
//        System.out.println(NumberFormat.getCurrencyInstance(ukLocale).format(1212121212));

//        ULocale[] locales = ULocale.getAvailableLocales();
        /*for (ULocale uLocale :locales) {
            System.out.println(uLocale.getDisplayLanguage());
            System.out.println(uLocale.getLanguage());
            System.out.println(uLocale.getISO3Language());
            System.out.println(uLocale.toLanguageTag());
            System.out.println(uLocale.getDisplayLanguage(uLocale));
//            System.out.println(NumberFormat.getCurrencyInstance(uLocale).format(1212121212));
        }*/

    }
/*
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
    }*/
}
