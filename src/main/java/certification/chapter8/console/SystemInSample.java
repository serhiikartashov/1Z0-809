package certification.chapter8.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Serhii K. on 3/16/2016.
 */
public class SystemInSample {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("You entered the following: "+userInput);
    }
}
