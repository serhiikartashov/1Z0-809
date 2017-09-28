package certification.chapter3.collections.list;

import java.util.*;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class ArrayListExample {

    public static void main(String[] args) {
        //        ArrayList Creation
        List<Integer> arraylistA = new ArrayList<>();
        List<String> arraylistB = new ArrayList<>();
        //        Adding elements to the ArrayList
        for (int i = 0; i < 5; i++) {
            arraylistA.add(i);
        }
        arraylistB.add("beginner");
        arraylistB.add("java");
        arraylistB.add("tutorial");
        arraylistB.add(".");
        arraylistB.add("com");
        arraylistB.add("java");
        arraylistB.add("site");
        //      Iterating through the ArrayList to display the Contents.
        Iterator i1 = arraylistA.iterator();
        System.out.print("ArrayList arraylistA --> ");
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }
        System.out.println();
        System.out.print("ArrayList arraylistA --> ");
        for (int j = 0; j < arraylistA.size(); j++) {
            System.out.print(arraylistA.get(j) + " , ");
        }
        System.out.println();
        Iterator i2 = arraylistB.iterator();
        System.out.println("ArrayList arraylistB --> ");
        while (i2.hasNext()) {
            System.out.print(i2.next() + " , ");
        }
        System.out.println();
        System.out.println();
        System.out
                .println("Using ListIterator to retrieve ArrayList Elements");
        System.out.println();
        ListIterator li1 = arraylistA.listIterator();
        //     next(), hasPrevious(), hasNext(), hasNext() nextIndex() can be used with a
        //     ListIterator interface implementation
        System.out.println("ArrayList arraylistA --> ");
        while (li1.hasNext()) {
            System.out.print(li1.next() + " , ");
        }
        System.out.println();
        //        Searching for an element in the ArrayList
        int index = arraylistB.indexOf("java");
        System.out.println("'java' was found at : " + index);
        int lastIndex = arraylistB.lastIndexOf("java");
        System.out.println("'java' was found at : " + lastIndex
                + " from the last");
        System.out.println();
        //        Getting the subList from the original List
        List subList = arraylistA.subList(3, arraylistA.size());
        System.out.println("New Sub-List(arraylistA) from index 3 to "
                + arraylistA.size() + ": " + subList);
        System.out.println();
        //        Sort an ArrayList
        System.out.print("Sorted ArrayList arraylistA --> ");
        Collections.sort(arraylistA);
        System.out.print(arraylistA);
        System.out.println();
        //      Reversing an ArrayList
        System.out.print("Reversed ArrayList arraylistA --> ");
        Collections.reverse(arraylistA);
        System.out.println(arraylistA);
        System.out.println();
        //		Checking emptyness of an ArrayList
        System.out.println("Is arraylistA empty?   "
                + arraylistA.isEmpty());
        System.out.println();
        //        Checking for Equality of ArrayLists
        ArrayList arraylistC = new ArrayList<>(arraylistA);
        System.out.println("arraylistA.equals(arraylistC)? "
                + arraylistA.equals(arraylistC));
        System.out.println();
        //      Shuffling the elements of an ArrayList in Random Order
        Collections.shuffle(arraylistA, new Random());
        System.out
                .print("ArrayList arraylistA after shuffling its elements--> ");
        i1 = arraylistA.iterator();
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }
        System.out.println();
        System.out.println();
        //        Converting an ArrayList to an Array
        Object[] array = arraylistA.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array Element [" + i + "] = " + array[i]);
        }
        System.out.println();
        //        Clearing ArrayList Elements
        arraylistA.clear();
        System.out.println("arraylistA after clearing  : " + arraylistA);
        System.out.println();
    }
}
