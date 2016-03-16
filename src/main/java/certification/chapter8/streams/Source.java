package certification.chapter8.streams;

import certification.chapter2.functional_interface.Animal;
import certification.chapter2.functional_interface.CheckTrait;

/**
 * Created by Serhii K. on 2/4/2016.
 */
public class Source {
    private static void print(Animal animal, CheckTrait trait){
        if (trait.test(animal))
            System.out.println(animal);
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.isCanHop());
        print(new Animal("fish", false, true), a -> a.isCanSwim());
        print(new Animal("kangaroo", true, false), a -> a.isCanSwim());

        print(new Animal("fish", false, true),
                (Animal a) -> {return a.isCanHop();});

        /*
        Duck d -> d.quack() // DOES NOT COMPILE
        a, d -> d.quack() // DOES NOT COMPILE
        Animal a, Duck d -> d.quack() // DOES NOT COMPILE
        */

        /*
        (int y, z) -> {int x=1; return y+10; } // DOES NOT COMPILE
        (String	s, z) -> { return s.length()+z;	} // DOES NOT COMPILE
        (a,	Animal	b,	c)	->	a.getName() // DOES NOT COMPILE
        */

    }
}
