package certification.chapter3.generics.bounds;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class Unbound {

    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }
}
