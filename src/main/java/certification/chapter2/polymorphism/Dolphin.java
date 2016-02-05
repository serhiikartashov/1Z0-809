package certification.chapter2.polymorphism;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class Dolphin implements LivesInOcean {
    @Override
    public void makeSound() {
        System.out.println("whistle");
    }
}
