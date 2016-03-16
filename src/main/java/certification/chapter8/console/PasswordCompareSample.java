package certification.chapter8.console;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by Serhii K. on 3/16/2016.
 */
public class PasswordCompareSample {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            char[] password = console.readPassword("Enter your password: ");
            console.format("Enter your password again: ");
            console.flush();
            char[] verify = console.readPassword();
            boolean match = Arrays.equals(password, verify);
            // Immediately clear passwords from memory
            /*for (int i = 0; i < password.length; i++) {
                password[i] = 'x';
            }*/
            Arrays.fill(password, 'x');
            /*for (int i = 0; i < verify.length; i++) {
                verify[i] = 'x';
            }*/
            Arrays.fill(verify, 'x');
            console.format("Your password was " + (match ? "correct\n" : "incorrect\n"));
            System.out.println(password);
            System.out.println(verify);
        }
    }
}
