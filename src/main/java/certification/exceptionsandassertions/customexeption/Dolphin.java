package certification.exceptionsandassertions.customexeption;

/**
 * Created by Serhii K. on 12/30/2015.
 */
class CannotSwimException extends Exception{
    public CannotSwimException(){
        super();
    }
    public CannotSwimException(Exception e){
        super(e);
    }

    public CannotSwimException(String message){
        super(message);
    }
}
class DangerInTheWater extends RuntimeException {}
class SharkInTheWaterException extends DangerInTheWater{}

public class Dolphin {
    public void swim() throws CannotSwimException{
        // wrapping exception
        throw	new	CannotSwimException(new	RuntimeException());
    }
}
