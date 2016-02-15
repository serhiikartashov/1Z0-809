package certification.chapter3.collections.java8_methods;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class TestClass {

    public static void main(String[] args) {

        // Collection

        // removeIf
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);        // [Magician, Assistant]
        list.removeIf("A"::startsWith);
        System.out.println(list);        // [Magician]

        System.out.println();

        // replaceAll
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        list2.replaceAll(x -> x * 2 + 1 );
        System.out.println(list2); // [2, 4, 6]

        System.out.println();

        // forEach
        List<String> cats = Arrays.asList("Annie", "Ripley");
        for (String cat : cats) System.out.println(cat);

        cats.forEach(c -> System.out.println(c));

        cats.forEach(System.out::println);

        System.out.println();

        // Map

        // putIfAbsent
        Map<String, String> favorites1 = new HashMap<>();
        favorites1.put("Jenny", "Bus Tour");
        favorites1.put("Jenny", "Tram");
        System.out.println(favorites1);    // {Jenny=Tram}


        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", null); // skips to set null value
        favorites2.putIfAbsent("Jenny", "Tram");
        favorites2.putIfAbsent("Sam", "Tram");
        favorites2.putIfAbsent("Tom", "Tram");
        System.out.println(favorites2); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

        System.out.println();

        // merge


        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length()
                        ?
                        v1
                        :
                        v2;
        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Jenny", "Bus Tour");
        favorites3.put("Tom", "Tram");
        System.out.println(favorites3);
        String jenny = favorites3.merge("Jenny", "Skyride", mapper);
        String tom = favorites3.merge("Tom", "Skyride", mapper);
        System.out.println(favorites3); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride

        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Sam", null);
        favorites4.merge("Tom", "Skyride", mapper);
        favorites4.merge("Sam", "Skyride", mapper);
        System.out.println(favorites4); // {Tom=Skyride, Sam=Skyride}

        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        Map<String, String> favorites5 = new HashMap<>();
        favorites5.put("Jenny", "Bus Tour");
        favorites5.put("Tom", "Bus Tour");
        favorites5.merge("Jenny", "Skyride", mapper);
        favorites5.merge("Sam", "Skyride", mapper);
        System.out.println(favorites5);    // {Tom=Bus Tour, Sam=Skyride}

        System.out.println();

        // computeIfPresent

        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);

        BiFunction<String, Integer, Integer> mapper3 =
                (k, v) -> v + 1;
        Integer jenny2 = counts.computeIfPresent("Jenny", mapper3);
        Integer sam2 = counts.computeIfPresent("Sam", mapper3);
        System.out.println(counts);    // {Jenny=2}
        System.out.println(jenny2);    // 2
        System.out.println(sam2);    // null

        System.out.println();

        // computeIfAbsent
        Map<String, Integer> counts2 = new HashMap<>();
        counts2.put("Jenny", 15);
        counts2.put("Tom", null);
        Function<String, Integer> mapper4 = (k) -> 1;
        Integer jenny3 = counts.computeIfAbsent("Jenny", mapper4);    // 15
        System.out.println(jenny3);
        Integer sam3 = counts.computeIfAbsent("Sam", mapper4);    // 1
        System.out.println(sam3);
        Integer tom2 = counts.computeIfAbsent("Tom", mapper4);    // 1
        System.out.println(tom2);
        System.out.println(counts2);    // {Tom=1, Jenny=15, Sam=1}

    }
}
