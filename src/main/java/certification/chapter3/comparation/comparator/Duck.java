package certification.chapter3.comparation.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class Duck implements Comparable<Duck> {

    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        Comparator<Duck> byWeight1 =
                (d1, d2) -> d1.getWeight() - d2.getWeight();

        Comparator<Duck> byWeight2 =
                (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();

        Comparator<Duck> byWeight3 = (d1, d2) -> {
            return d1.getWeight() - d2.getWeight();
        };
        Comparator<Duck> byWeight4 = (Duck d1, Duck d2) -> {
            return d1.getWeight() - d2.getWeight();
        };

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));

        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
    }

}
