package certification.chapter3.search_and_sort;

import certification.chapter3.comparation.comparable.Duck;

import java.util.*;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class SortRabbits {

    static class Rabbit {
        int id;
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);

        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c1 = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy", c1);
        System.out.println(index); // -1


        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles"));
        Set<Rabbit> rabbit1 = new TreeSet<>();
        // Rabbit does not implement comparable interface
        rabbit1.add(new Rabbit()); // throws an exception at runtime

        Set<Rabbit> rabbit2 = new TreeSet<>(new Comparator<Rabbit>() {
            public int compare(Rabbit r1, Rabbit r2) {
                return r1.id = r2.id;
            }
        });
        rabbit2.add(new Rabbit());

    }
}
