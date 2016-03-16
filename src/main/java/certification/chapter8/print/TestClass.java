package certification.chapter8.print;

import certification.chapter8.serialization.Animal;

import java.io.*;

/**
 * Created by Serhii K. on 3/16/2016.
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        /*PrintWriter out = new PrintWriter("zoo.log");
        out.print(5); // PrintWriter method*/
//        out.write(String.valueOf(5)); // Writer method

/*        out.print(2.0); // PrintWriter method
        out.write(String.valueOf(2.0)); // Writer method

        Animal animal = new Animal("monkey", 1, 'm');
        out.print(animal); // PrintWriter method
        out.write(animal==null ? "null": animal.toString()); // Writer method*/

        File source = new File("zoo.log");
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(source)))) {
            out.print("Today's weather is: ");
            out.println("Sunny");
            out.print("Today's temperature at the zoo is: ");
            out.print(1/3.0);
            out.println('C');
            out.format("It has rained 10.12 inches this year");
            out.println();
            out.printf("It may rain 21.2 more inches this year");
        }
    }
}
