package certification.localization.localization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/30/2015.
 */
public class MyLocalization {

    public static void main(String[] args) {

        List<Locale.LanguageRange> list1 = new ArrayList<>();
        list1.add(new Locale.LanguageRange("en-ua"));
        List<Locale> list2 = new ArrayList<>();
        list2.add(new Locale("fr", "FR"));
        list2.add(new Locale("pl", "POL"));
        list2.add(new Locale("uk", "UKR"));
        List<Locale> list3 = Locale.filter(list1,list2);

        Locale locale = Locale.forLanguageTag("fr-FR");
        System.out.println(locale.getDisplayName());

        Locale locale2 = Locale.forLanguageTag("uk-UKR");
        System.out.println(locale2.getScript());

        //Locale locale3 = Locale.forLanguageTag("th_TH_TH_#u-nu-thai");
        Locale locale3 = Locale.forLanguageTag("th-TH-TH-#u-nu-thai");
        System.out.println(locale3);
        System.out.println("Locale Type: " + locale3.getUnicodeLocaleType("nu"));
        //Locale locale3 = Locale.forLanguageTag("th-TH");
        /*System.out.println("Display Name: " + locale3.getDisplayName());
        System.out.println("Script" + locale3.getScript());
        System.out.println("UnicodeLocaleAttributes: " + locale3.getUnicodeLocaleAttributes());
        System.out.println("Unicode Locale Keys" + locale3.getUnicodeLocaleKeys());*/
        //System.out.println(locale3.getUnicodeLocaleType("key"));


        list3.forEach(System.out::println);

        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale1 : locales) {
            if (!locale1.getUnicodeLocaleAttributes().isEmpty() ||
                    !locale1.getUnicodeLocaleKeys().isEmpty() ||
                    !locale1.getScript().isEmpty()) {
                System.out.println(locale1);
                System.out.println("Display Name: " + locale1.getDisplayName());
                System.out.println("Script: " + locale1.getScript());
                System.out.println("UnicodeLocaleAttributes: " + locale1.getUnicodeLocaleAttributes());
                System.out.println("Unicode Locale Keys: " + locale1.getUnicodeLocaleKeys());
                System.out.println("Extension Keys: " + locale1.getExtensionKeys());
                System.out.println();

                if (!locale1.getUnicodeLocaleKeys().isEmpty() &
                        locale1.getUnicodeLocaleKeys().contains("nu") ){
                    System.out.println("Locale Type: " + locale1.getUnicodeLocaleType("nu"));
                    System.out.println();
                }

                if (!locale1.getUnicodeLocaleKeys().isEmpty() &
                        locale1.getUnicodeLocaleKeys().contains("ca") ){
                    System.out.println("Locale Type: " + locale1.getUnicodeLocaleType("ca"));
                    System.out.println();
                }
            }
        }
        //Arrays.asList(locales).forEach(System.out::println);
    }
}
