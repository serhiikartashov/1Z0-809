package certification.chapter3.collections.set;

import java.util.*;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class HashSetExample {

    private static String names[] = { "bob", "hemanth", "hhh", "hero",
            "shawn", "bob", "mike", "Rick", "rock", "hemanth", "mike",
            "undertaker" };
    public static void main(String args[]) {
        ArrayList aList = new ArrayList(Arrays.asList(names));
        System.out.println("The names elements " + aList);

        HashSet ref = new HashSet(aList); // create a HashSet

        Iterator i = ref.iterator();
        System.out.println();
        System.out.print("Unique names are: ");
        while (i.hasNext())
            System.out.print(i.next() + " ");
        System.out.println();
    }
}
