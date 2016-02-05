package certification.chapter5.localization.format.serviceproviders;

/**
 * Created by Serhii K. on 11/27/2015.
 */
/*
public class UkrCurrencyNameProvider extends CurrencyNameProvider {
    private static final Locale XX_YY = new Locale("xx", "YY");
    private static final Locale UK_UA = new Locale("uk", "UA");
    private static final Map<Locale, String> SYMBOL_MAP;

    static {
        SYMBOL_MAP = new HashMap<Locale, String>();
        UkrCurrencyNameProvider.SYMBOL_MAP.put(UkrCurrencyNameProvider.XX_YY,
                "BungaBunga");
        UkrCurrencyNameProvider.SYMBOL_MAP.put(UK_UA, "ungarn$$$");
    }

    private static final Locale[] AVAILABLE_LOCALES = UkrCurrencyNameProvider.SYMBOL_MAP
            .keySet().toArray(
                    new Locale[UkrCurrencyNameProvider.SYMBOL_MAP.size()]);

    */
/*
     * (non-Javadoc)
     * @see java.util.spi.CurrencyNameProvider#getSymbol(java.lang.String,
     * java.util.Locale)
     *//*

    @Override
    public String getSymbol(final String currencyCode, final Locale locale) {
        final String result;
        if ("UAH".equals(currencyCode)) {
            result = UkrCurrencyNameProvider.SYMBOL_MAP.get(locale);
        } else {
            result = null;
        }
        return result;
    }

    */
/*
     * (non-Javadoc)
     * @see java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *//*

    @Override
    public Locale[] getAvailableLocales() {
        return UkrCurrencyNameProvider.AVAILABLE_LOCALES.clone();

    }

    public static void main(String[] args) {
        Locale[] test=new Locale[] {new Locale("xx","YY"),new Locale("uk","UA")};
        for (Locale loc:test)
        {System.out.println(loc+": "+ Currency.getInstance("UAH").getSymbol(loc));}
    }

}*/
