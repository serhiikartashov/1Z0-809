package certification.localization.format;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class FractionDigits {
    public static void main(String[] args) throws ParseException {
        String[] numbers = {"1.222", "0.12345F"};
        double[] doubles = {1.222, 0.12345F};
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        System.out.println("Using format method: ");
        for (double val : doubles) {
            System.out.println(numberFormat.format(val));
        }
        System.out.println("Using parse method: ");
        for (String number : numbers) {
            System.out.println(numberFormat.parse(number));
         }
    }
}
