package certification.chapter3.comparation.comparable;

/**
 * Created by Serhii K. on 2/15/2016.
 */
// you have to cust to the object if you miss this Animal definition
// in Comparable interface
public class Animal implements Comparable<Animal> {

    private int id;

    @Override
    public int compareTo(Animal o) {
        // Remember that id – a.id sorts in ascending order
        // and a.id – id sorts in descending order.
        return id - o.id;
    }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}
