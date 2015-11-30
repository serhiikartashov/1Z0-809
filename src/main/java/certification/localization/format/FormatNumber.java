package certification.localization.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class FormatNumber {
    public static void main(String[] args) {
        Locale[] locales = NumberFormat.getAvailableLocales();
        for (Locale locale:locales) {
            parseNumber(locale);
        }
    }

    private static void parseNumber(Locale locale) {
        long tenMillion = 10_000_000L;
        NumberFormat germanFormat = NumberFormat.getInstance(locale);
        String localizedTenMillion = germanFormat.format(tenMillion);
        System.out.println("Ten million in " + locale.getDisplayName() + " locale is " + localizedTenMillion);

        try {
            Number parsedAmount = germanFormat.parse(localizedTenMillion);
            if (tenMillion== parsedAmount.longValue()){
                System.out.println("successfully parsed the number for the locale");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
