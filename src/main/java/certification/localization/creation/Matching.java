package certification.localization.creation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/30/2015.
 */
public class Matching {

    public static void main(String[] args) {
        //lookup();
        filtering();
    }

    public static void filtering(){

        List<Locale.LanguageRange> list1 = new ArrayList<>();
        list1.add(new Locale.LanguageRange("en-US"));
        list1.add(new Locale.LanguageRange("it-*"));
        list1.add(new Locale.LanguageRange("de"));
        list1.add(new Locale.LanguageRange("de-*-DE"));
        list1.add(new Locale.LanguageRange("fr-FR"));
        list1.add(new Locale.LanguageRange("fr-*"));
        list1.add(new Locale.LanguageRange("*-ca"));
        list1.add(new Locale.LanguageRange("*-CH"));
        list1.add(new Locale.LanguageRange("ja-jp-u"));
        // will find all locales with countries, not just languages
        //list1.add(new Locale.LanguageRange("*-*"));

        // Locales
        List<Locale> list3 = Locale.filter(list1,
                Arrays.asList(Locale.getAvailableLocales()));
        list3.forEach(System.out::println);

        /*List<Locale> list4 = Locale.filter(list1,
                Arrays.asList(Locale.getAvailableLocales()),
                Locale.FilteringMode.MAP_EXTENDED_RANGES);
        list4.forEach(System.out::println);*/

        // Language Tags
        List<Locale> availableLocales = Arrays.asList(Locale.getAvailableLocales());
        List<String> availableTags = new ArrayList<>();
        for (Locale availableLocale : availableLocales) {
            availableTags.add(availableLocale.toLanguageTag());
        }
        List<String> languageTags = Locale.filterTags(list1,
                availableTags);
        languageTags.forEach(System.out::println);
    }

    public static void lookup(){

        List<Locale.LanguageRange> list1 = new ArrayList<>();
        //list1.add(new Locale.LanguageRange("fr-FR"));
        list1.add(new Locale.LanguageRange("zh-Hant-TW"));
        list1.add(new Locale.LanguageRange("en-US"));
        list1.add(new Locale.LanguageRange("*"));

        /*List<Locale> list2 = new ArrayList<>();
        list2.add(new Locale("fr", "FR"));
        list2.add(new Locale("pl", "POL"));
        list2.add(new Locale("uk", "UKR"));*/
        // Locale
        Locale locale1 = Locale.lookup(list1,
                Arrays.asList(Locale.getAvailableLocales()));
        System.out.println(locale1);

        // Language Tag
        List<Locale> availableLocales = Arrays.asList(Locale.getAvailableLocales());
        List<String> availableTags = new ArrayList<>();
        for (Locale availableLocale : availableLocales) {
            availableTags.add(availableLocale.toLanguageTag());
        }
        String languageTag = Locale.lookupTag(list1,
                availableTags);
        System.out.println(languageTag);
    }
}


