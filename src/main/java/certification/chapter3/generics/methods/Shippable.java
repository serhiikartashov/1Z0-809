package certification.chapter3.generics.methods;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public interface Shippable<T> {
    void ship(T t);
}

class Robot{}
class ShippableRobotCrate implements Shippable<Robot>{

    @Override
    public void ship(Robot robot) {

    }
}

class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t){}
}