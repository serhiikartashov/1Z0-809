package certification.chapter2.polymorphism;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class Oceanographer {
    public void checkSound(LivesInOcean animal){
        animal.makeSound();
    }

    public static void main(String[] args) {
        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());
    }
}
