package certification.chapter5.localization.format;

import java.util.*;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class CurrencyExample {

    public static void main(String[] args)
    {
        /*Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            Utils.getCurrencySymbol(Currency.getInstance(locale).getCurrencyCode());
        }*/
        Utils.getCurrencySymbol(Currency.getInstance(Locale.US).getCurrencyCode());
        Utils.getCurrencySymbol(Currency.getInstance(Locale.JAPAN).getCurrencyCode());
        Utils.getCurrencySymbol(Currency.getInstance(Locale.UK).getCurrencyCode());
        Utils.getCurrencySymbol(Currency.getInstance(new Locale("uk", "UKR")).getCurrencyCode());
        Utils.getCurrencySymbol("INR");
    }
}

class Utils{
    public static SortedMap<Currency, Locale> currencyLocaleMap;
    static {
        currencyLocaleMap = new TreeMap<Currency, Locale>(new Comparator<Currency>() {
            public int compare(Currency c1, Currency c2){
                return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
            }
        });
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencyLocaleMap.put(currency, locale);
            }catch (Exception e){
            }
        }
    }

    public static String getCurrencySymbol(String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        System.out.println( currencyCode+ ":-" + currency.getSymbol(currencyLocaleMap.get(currency)));
        return currency.getSymbol(currencyLocaleMap.get(currency));
    }
}