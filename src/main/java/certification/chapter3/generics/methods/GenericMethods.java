package certification.chapter3.generics.methods;

import certification.chapter3.generics.types.Crate;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class GenericMethods {

    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<>();
    }

    public static <T> void sink(T t) {
    }

    public static <T> T identity(T t) {
        return t;
    }
}
