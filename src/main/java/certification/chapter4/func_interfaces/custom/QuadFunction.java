package certification.chapter4.func_interfaces.custom;

/**
 * Created by Serhii K. on 2/15/2016.
 */
@FunctionalInterface
interface QuadFunction<T, U, V, W, R> {

    R apply(T t, U u, V v, W w);
}