package certification.chapter8.console;

import java.io.Console;

/**
 * Created by Serhii K. on 3/16/2016.
 */
public class ConsoleSample {

    public static void main(String[] args) {
        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println ("You entered the following: "+userInput);
        }
    }
}
