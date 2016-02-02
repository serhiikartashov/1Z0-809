package certification.chapter1.instanceof_operator;

/**
 * Created by Serhii K. on 2/1/2016.
 */

class HeavyAnimal {
}

class Hippo extends HeavyAnimal {
}

class Elephant extends HeavyAnimal {
}

interface Mother {
}

public class TestClass1 {


    public static void main(String[] args) {
        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo; // true
        boolean b2 = hippo instanceof HeavyAnimal; // true
        boolean b3 = hippo instanceof Elephant; // false

        boolean b4 = hippo instanceof Object; // true
        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object; // false

        Hippo anotherHippo = new Hippo();
        //boolean b6 = anotherHippo instanceof Elephant; // DOES NOT COMPILE
        boolean b6 = anotherHippo instanceof Mother; // false
        System.out.println("");
    }

    /*public void feedAnimal(Animal animal) {
        if (animal instanceof Cow) {
            ((Cow) animal).addHay();
        } else if (animal instanceof Bird) {
            ((Bird) animal).addSeed();
        } else if (animal instanceof Lion) {
            ((Lion) animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported	animal");
        }
    }*/
}
