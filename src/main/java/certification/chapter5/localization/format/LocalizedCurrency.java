package certification.chapter5.localization.format;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class LocalizedCurrency {


    public static void main(String[] args) {
        long tenMillion = 10000000L; // this is ten million
        /*Locale[] locales = {Locale.CANADA, Locale.FRANCE,
                Locale.GERMANY, Locale.TAIWAN};*/
        Locale[] locales = Locale.getAvailableLocales();
        String[] contriesCodes = Locale.getISOCountries();
        //Locale[] locales = NumberFormat.getAvailableLocales();
        String[] currencies = new String[locales.length];
        // for each of the four locales,
        // print the currency amount as it looks in that locale
        int i = 0;
        for (Locale locale : locales) {
//            Currency currency =
            if (!locale.getCountry().equals("")){
            String currency = "Ten million in " + locale.getDisplayName() + "  is " +
                    NumberFormat.getCurrencyInstance(locale).format(tenMillion);
            //if (currency.contains("¤"))
            //if (locale.getDisplayName().equals("Ukrainian")){
            //if (!locale.getScript().equals("")){
                System.out.println(currency);
                //System.out.println(locale.getScript());
                System.out.println(Currency.getInstance("UAH").getSymbol(locale));
            }
            //currencies[i] = currency;

            /*System.out.println("Ten percent in " + locale.getDisplayName() + "  is " +
                    NumberFormat.getPercentInstance(locale).format(tenMillion));*/
            //System.out.println(NumberFormat.getPercentInstance(locale).getCurrency().getSymbol());
            i++;
        }
        Locale uaLoc = new Locale("uk", "UA");
        String currency = "Ten million in " + uaLoc.getDisplayName() + "  is " +
                NumberFormat.getCurrencyInstance(uaLoc).format(tenMillion);
        System.out.println(currency);
        System.out.println(Currency.getInstance("UAH").getSymbol(uaLoc));
        //javax.swing.JOptionPane.showMessageDialog(null, currencies);
        getAllSymbols();
    }

    private static void getAllSymbols(){
        Locale [] locales = Locale.getAvailableLocales();

        for(Locale l: locales){
            if( null == l.getCountry() || l.getCountry().isEmpty())
                continue;
            Currency c = Currency.getInstance(l);
            System.out.println(l.getCountry() + "   " + c.getSymbol() + "  " + c.getSymbol(l));
        }
    }
}
