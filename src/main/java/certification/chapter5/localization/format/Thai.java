package certification.chapter5.localization.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/25/2015.
 */
public class Thai {

    public static void main(String[] args) {

        Locale[] thaiLocale = {
                new Locale("th"),
                new Locale("th", "TH"),
                new Locale("th", "TH", "TH")
        };
        getString(thaiLocale);
        Locale[] ukraineLocale = {
                new Locale("uk"),
                new Locale("uk", "UKR"),
                new Locale("uk", "UKR", "UKR")
        };
        getString(ukraineLocale);
    }

    private static void getString(Locale[] thaiLocale) {
        String outputString = new String();

        for (Locale locale : thaiLocale) {
            //NumberFormat nf = NumberFormat.getNumberInstance(locale);
            NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
            outputString = outputString + locale.toString() + ": ";
            outputString = outputString + nf.format(573.34) + "\n";
            System.out.println(locale.getDisplayName() + " : "
                    + locale.getScript() + " : "
                    + locale.getDisplayScript());
        }
        System.out.println(outputString);
    }
}
