package certification.chapter5.localization.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class LocalizedHello2 {

    public static void printMovieDetails(ResourceBundle resBundle) {
        // the keyname is case sensitive and the key name should exactly match
        String movieName = resBundle.getString("MovieName");
        Long revenue = (Long) (resBundle.getObject("GrossRevenue"));
        Integer year = (Integer) (resBundle.getObject("Year"));
        System.out.println("Movie " + movieName + "(" + year + ")" + " grossed " + revenue);
    }

    public static void main(String[] args) {
        // For the resource bundles implemented as classes extended from ListResourceBundles,
        // Java uses the reflection mechanism to find and load the class.
        // that's why we added package (full path)
        Locale locale1 = Locale.getDefault();
        printMovieDetails(ResourceBundle.getBundle("certification.chapter5.localization.resourcebundle.ResBundle", locale1));

        Locale locale2 = new Locale("it", "IT");
        printMovieDetails(ResourceBundle.getBundle("certification.chapter5.localization.resourcebundle.ResBundle", locale2));
    }
}
