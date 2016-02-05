package certification.chapter2.design_principles;

/**
 * Created by Serhii K. on 2/5/2016.
 */

// Composing Objects

class Flippers {
    public void flap(){
        System.out.println("The flippers flap back and forth");
    }
}

class WebbedFeet {
    public void kick(){
        System.out.println("The webbed feet kick to and fro");
    }
}

public class Penguin {

    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin(){
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap(){
        this.flippers.flap();
    }

    public void kick(){
        this.webbedFeet.kick();
    }
}
