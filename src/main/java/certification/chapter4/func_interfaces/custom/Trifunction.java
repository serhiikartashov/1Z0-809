package certification.chapter4.func_interfaces.custom;

/**
 * Created by Serhii K. on 2/15/2016.
 */
@FunctionalInterface
public interface Trifunction<T,U,V,R> {

    R apply(T t, U u, V v);
}
