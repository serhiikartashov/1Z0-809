package certification.chapter3.collections.set;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class TreeSetExample {

    public static void doTreeSetExample() {
    }
    public static void main(String[] args) {
        Set treeSet = new TreeSet();
        // the treeset stores Integer objects into the TreeSet
        for (int i = 0; i < 5; i++) {
            new Random().nextInt();
            treeSet.add(new Random().nextInt());
            //treeSet.add(new Integer(i));
        }
        // Since its a Integer Object Set adding any other elements in the Same
        // set will produce a
        // ClassCastException exception at runtime.
        // treeSet.add("a string");
        System.out.print("The elements of the TreeSet are : ");
        Iterator i = treeSet.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + "\t");
        }
    }
}
