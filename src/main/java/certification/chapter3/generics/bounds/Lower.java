package certification.chapter3.generics.bounds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class Lower {

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public void foo() {
        List<? super IOException> exceptions = new ArrayList<>();
        //exceptions.add(new Exception()); // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }

    public static void addSound(List<? super String> list) {// lower bound
        list.add("");
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");

        List<Object> objects = Arrays.asList(new Object());
        addSound(strings);
        addSound(objects);

    }
}
