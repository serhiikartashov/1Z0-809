package certification.chapter3.generics.types;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class Crate<T> {

    private T t;

    public void packCrate(T t){
        this.t = t;
    }

    public T emptyCrate(){
        return t;
    }
}
