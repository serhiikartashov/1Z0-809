package certification.chapter5.localization.format;

import java.util.Locale;

/**
 * Created by Serhii K. on 11/25/2015.
 */
public class Extensions {
    public static void main(String[] args) {
        String[] languages = Locale.getISOLanguages();
        String[] countries = Locale.getISOCountries();

        /*for (String lang :countries) {
            System.out.println(lang);
        }*/
        //Locale locale = Locale.getDefault();
        Locale[] available = Locale.getAvailableLocales();
        System.out.println("Ext Keys: ");
        for (Locale locale : available) {
            locale.getExtensionKeys().forEach(System.out::println);
        }
        System.out.println("Unicode Keys: ");
        for (Locale locale : available) {
            locale.getUnicodeLocaleKeys().forEach(System.out::println);
            locale.getUnicodeLocaleAttributes().forEach(System.out::println);
        }

        //By default only Tai and Japanese have Ext Keys and Unicode Keys
        //Locale locale = new Locale("uk", "UKR");


    }
}
