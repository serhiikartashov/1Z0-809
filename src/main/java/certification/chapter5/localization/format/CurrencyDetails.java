package certification.chapter5.localization.format;

import java.text.DateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Serhii K. on 11/25/2015.
 */
public class CurrencyDetails {

    public static void main(String[] args) {
        //Locale locale = Locale.getDefault();
        //Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        Currency currency = Currency.getInstance(locale);
        System.out.println("The currency code for locale " + locale
                + " is: " + currency.getCurrencyCode()
                + " \n The currency symbol is " + currency.getSymbol()
                + " \n The currency name is " + currency.getDisplayName());

        System.out.println("  Unqualified:  " + Locale.getDefault());
        System.out.println("  Display:      " + Locale.getDefault(Locale.Category.DISPLAY));
        System.out.println("  Format:       " + Locale.getDefault(Locale.Category.FORMAT));


        String [] messages = {
                // language and country System properties
                "user.language = "          + System.getProperty("user.language"),
                "user.country = "           + System.getProperty("user.country"),
                "user.language.display = "  + System.getProperty("user.language.display"),
                "user.country.display = "   + System.getProperty("user.country.display"),
                "user.language.format = "   + System.getProperty("user.language.format"),
                "user.country.format = "    + System.getProperty("user.country.format"),
                // default locales
                "default locale = "         + Locale.getDefault(),
                "default display locale = " + Locale.getDefault(Locale.Category.DISPLAY),
                "default format locale = "  + Locale.getDefault(Locale.Category.FORMAT),
                // date test
                "Date: " + DateFormat.getDateInstance(DateFormat.FULL).format(new Date())};
        for (String message : messages) {
            System.out.println(message);
        }
        //javax.swing.JOptionPane.showMessageDialog(null, messages);

        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
        for (Currency availableCurrency : availableCurrencies) {
            System.out.println(availableCurrency.getDisplayName() + " : "
                    + availableCurrency.getSymbol() + " : "
                    + availableCurrency.getNumericCode() + " : "
                    + availableCurrency.getCurrencyCode());
        }


        Locale[] locales = Locale.getAvailableLocales();
        Locale germany = new Locale("de", "DE");
        //for (Locale locale1 : locales) {
            Currency currency1 = Currency.getInstance(germany);
            System.out.println(currency1.getDisplayName() + " : "
                    + currency1.getSymbol() + " : "
                    + currency1.getNumericCode() + " : "
                    + currency1.getCurrencyCode());
        //}
    }
}
