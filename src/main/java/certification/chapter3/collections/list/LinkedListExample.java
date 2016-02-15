package certification.chapter3.collections.list;

import java.util.*;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class LinkedListExample {

    public static void main(String[] args) {
        //        LinkedList Creation
        List linkedListA = new LinkedList();
        List linkedListB = new LinkedList();
        //        Adding elements to the LinkedList
        for (int i = 0; i < 5; i++) {
            linkedListA.add(new Integer(i));
        }
        linkedListB.add("beginner");
        linkedListB.add("java");
        linkedListB.add("tutorial");
        linkedListB.add(".");
        linkedListB.add("com");
        linkedListB.add("java");
        linkedListB.add("site");
        //      Iterating through the LinkedList to display the Contents.
        Iterator i1 = linkedListA.iterator();
        System.out.print("LinkedList linkedListA --> ");
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }
        System.out.println();
        System.out.print("LinkedList linkedListA --> ");
        for (int j = 0; j < linkedListA.size(); j++) {
            System.out.print(linkedListA.get(j) + " , ");
        }
        System.out.println();
        Iterator i2 = linkedListB.iterator();
        System.out.println("LinkedList linkedListB --> ");
        while (i2.hasNext()) {
            System.out.print(i2.next() + " , ");
        }
        System.out.println();
        System.out.println();
        System.out
                .println("Using ListIterator to retrieve LinkedList Elements");
        System.out.println();
        ListIterator li1 = linkedListA.listIterator();
        //next(), hasPrevious(), hasNext(), hasNext() nextIndex() can be used 
        //  with a ListIterator interface implementation
        System.out.println("LinkedList linkedListA --> ");
        while (li1.hasNext()) {
            System.out.print(li1.next() + " , ");
        }
        System.out.println();
        //        Searching for an element in the LinkedList
        int index = linkedListB.indexOf("java");
        System.out.println("'java' was found at : " + index);
        int lastIndex = linkedListB.lastIndexOf("java");
        System.out.println("'java' was found at : " + lastIndex
                + " from the last");
        System.out.println();
        //        Getting the subList from the original List
        List subList = linkedListA.subList(3, linkedListA.size());
        System.out.println("New Sub-List(linkedListA) from index 3 to "
                + linkedListA.size() + ": " + subList);
        System.out.println();
        //        Sort an LinkedList
        System.out.print("Sorted LinkedList linkedListA --> ");
        Collections.sort(linkedListA);
        System.out.print(linkedListA);
        System.out.println();
        //      Reversing an LinkedList
        System.out.print("Reversed LinkedList linkedListA --> ");
        Collections.reverse(linkedListA);
        System.out.println(linkedListA);
        System.out.println();
        //		Checking emptyness of an LinkedList
        System.out.println("Is linkedListA empty?   "
                + linkedListA.isEmpty());
        System.out.println();
        //        Checking for Equality of LinkedLists
        LinkedList LinkedListC = new LinkedList(linkedListA);
        System.out.println("linkedListA.equals(LinkedListC)? "
                + linkedListA.equals(LinkedListC));
        System.out.println();
        //      Shuffling the elements of an LinkedList in Random Order
        Collections.shuffle(linkedListA, new Random());
        System.out
                .print("LinkedList linkedListA after shuffling its elements--> ");
        i1 = linkedListA.iterator();
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }
        System.out.println();
        System.out.println();
        //        Converting an LinkedList to an Array
        Object[] array = linkedListA.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array Element [" + i + "] = " + array[i]);
        }
        System.out.println();
        //        Clearing LinkedList Elements
        linkedListA.clear();
        System.out.println("linkedListA after clearing  : " + linkedListA);
        System.out.println();
    }
}
