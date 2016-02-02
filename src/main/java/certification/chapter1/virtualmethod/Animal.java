package certification.chapter1.virtualmethod;

/**
 * Created by Serhii K. on 2/1/2016.
 */
// Java looks for an overridden method rather than necessarily
// using the one in the class that the compiler says we have
public abstract class Animal {
    public abstract void feed();
}

class Cow extends Animal {
    public void feed() {
        addHay();
    }

    private void addHay() {
    }
}

class Bird extends Animal {
    public void feed() {
        addSeed();
    }

    private void addSeed() {
    }
}

class Lion extends Animal {
    public void feed() {
        addMeat();
    }

    private void addMeat() {
    }
}