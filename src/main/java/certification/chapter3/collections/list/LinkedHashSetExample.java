package certification.chapter3.collections.list;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

/**
 * <p>
 *
 * @author Serhii Kartashov (serhii.kartashov@eleks.com)
 * @since 0.0.1
 */
public class LinkedHashSetExample {

    public static void main(String[] args) {

        ArrayList l1 = new ArrayList();
        l1.add("a1");
        l1.add("a2");
        l1.add("a3");
        l1.add("a4");
        l1.add("a5");
        l1.add("a6");

        System.out.println("List1 before");
        l1.stream().forEach(System.out::println);

        Iterator<String> it = l1.iterator();
        while (it.hasNext()) {
            String el = it.next();
            if (el.equals("a4")) {
                it.remove();
                l1.add("NEW VALUE");
            }
//            it.next();
        }

//        l1.removeIf(e -> e.equals("a4"));
//
//        replaceIf(l1,  x -> x.equals("a2"), "New Item");
//
        System.out.println("List1 after");
        l1.stream().forEach(System.out::println);

        System.out.println();

        Set set1 = new HashSet();
        set1.add("a1");
        set1.add("a2");
        set1.add("a3");
        set1.add("a4");
        set1.add("a5");
        set1.add("a6");

        System.out.println();

        System.out.println("Set before");
        set1.stream().forEach(System.out::println);

//        replaceIf(set1,  x -> x.equals("a2"), "New Item");

        System.out.println("Set after");
        set1.stream().forEach(System.out::println);

        // will throw java.util.ConcurrentModificationException for remove operation
//        for (Iterator<String> iterator = set1.iterator(); iterator.hasNext();){
//            String el = iterator.next();
//            if (el.equals("a4")){
//                iterator.remove();
//                set1.add("NEW VALUE");
//            }
//        }

        LinkedHashSet list = new LinkedHashSet();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");
        list.add("a6");

        // will throw java.util.ConcurrentModificationException for remove operation
//        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
//            String el = iterator.next();
//            if (el.equals("a4")){
//                iterator.remove();
//                list.add("NEW VALUE");
//            }
//        }

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue();
        queue.offer("a1");
        queue.offer("a2");
        queue.offer("a3");
        queue.offer("a4");
        queue.offer("a5");
        queue.offer("a6");

        queue.stream().forEach(System.out::println);

        for (Iterator<String> iterator = queue.iterator(); iterator.hasNext();){
            String el = iterator.next();
            if (el.equals("a4")){
                iterator.remove();
                queue.add("NEW VALUE");
            }
        }

        queue.stream().forEach(System.out::println);

        Set set = Collections.synchronizedSet(new LinkedHashSet());
        set.add("a1");
        set.add("a2");
        set.add("a3");
        set.add("a4");
        set.add("a5");
        set.add("a6");

        /*System.out.println("Set before");
        set.stream().forEach(System.out::println);

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();){
            String el = iterator.next();
            if (el.equals("a4")){
                iterator.remove();
                set.add("NEW VALUE");
            }
        }

        System.out.println("Set after");
        set.stream().forEach(System.out::println);*/


        Set<String> set11 = new HashSet<>();
        set11.add("a");
        Set<String> set22 = new HashSet<>();

        for (String v1 :
                set11) {
            System.out.println(v1);
        }

    }

    // works only with list
    public static <T> void replaceIf(List<T> list, Predicate<T> predicate, T replacement) {
        for (int i = 0; i < list.size(); ++i)
            if (predicate.test(list.get(i)))
                list.set(i, replacement);
    }

//    public static <T> void replaceIfSet(Set<T> set, Predicate<T> predicate, T replacement) {
//        for (int i = 0; i < set.size(); ++i)
//            if (predicate.test(set.get(i)))
//                set.set(i, replacement);

}
