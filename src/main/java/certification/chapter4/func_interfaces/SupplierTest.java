package certification.chapter4.func_interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder("string");

        System.out.println(s3.get());
        System.out.println(s4.get());

        Supplier<ArrayList<String>> s5 = ArrayList<String>::new;
        ArrayList<String> a5 = s5.get();
        System.out.println(a5);


        System.out.println(s1);
        // certification.chapter4.func_interfaces.SupplierTest$$Lambda$1/1747585824@6e8cf4c6
        // $$ means that the class doesn't exist in a class file
        // on the file system. IT exists only in memory.
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
