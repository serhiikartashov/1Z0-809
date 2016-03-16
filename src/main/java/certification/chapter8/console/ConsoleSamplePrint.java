package certification.chapter8.console;

import java.io.Console;

/**
 * Created by Serhii K. on 3/16/2016.
 */
public class ConsoleSamplePrint {

    // java -cp ./target/classes certification.chapter8.console.ConsoleSamplePrint
    // If the virtual machine is started automatically, for example by a background job scheduler,
    // then it will typically not have a console.
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to Our Zoo!");
            console.format("Our zoo has 391 animals and employs 25 people.");
            console.writer().println();
            console.printf("The zoo spans 128.91 acres.");
            System.out.println();

            /*char[] pass = console.readPassword();
            String str = String.valueOf(pass);
            System.out.println(str);*/

            /*String fmt = "%2$5s %3$10s%n";
            char[] pwd = console.readPassword(fmt,"Enter","Password: ");
            System.out.println(pwd);*/

            char passwordArray[] = console.readPassword("Enter your secret password: ");
            console.printf("Password entered was: %s%n", new String(passwordArray));

            /*Character[] charObjectArray = str.chars()
                    .mapToObj(c -> (char)c)
                    .toArray(Character[]::new);*/
        }

        // older implementation
        /*Scanner in;
        in = new Scanner(System.in);
        String s = in.nextLine();*/
    }
}
