package certification.chapter3.comparation.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class Duck implements Comparable<Duck> {

    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public String toString() { // use readable output
        return name;
    }

    public int compareTo(Duck d) {
        return name.compareTo(d.name);    // call String's compareTo
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);          // sort by name
        System.out.println(ducks);        // [Puddles, Quack]
    }
}
