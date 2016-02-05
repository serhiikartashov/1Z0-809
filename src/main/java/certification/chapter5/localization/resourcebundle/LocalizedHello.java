package certification.chapter5.localization.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class LocalizedHello {

    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("ResourceBundle", currentLocale);
        System.out.printf(resourceBundle.getString("Greeting"));
    }
}
