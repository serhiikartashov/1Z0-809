package certification.chapter7.examples.copy_on_write_arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.print(item + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size());
    }
}
