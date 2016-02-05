package certification.chapter2.lambdas;

import certification.chapter2.functional_interface.Animal;

import java.util.function.Predicate;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class FindMatchingAnimalsPredicate {

    private static void print(Animal animal, Predicate<Animal> trait){
        if (trait.test(animal))
            System.out.println(animal);
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.isCanHop());
        print(new Animal("fish", false, true), a -> a.isCanSwim());
        print(new Animal("kangaroo", true, false), a -> a.isCanSwim());
    }
}
