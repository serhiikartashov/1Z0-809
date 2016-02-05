package certification.chapter6.trywithresources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Created by Serhii K. on 12/30/2015.
 */
public class TestClass {

    public void oldApproach(Path path1, Path path2) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            out.write(in.readLine());
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    public void newApproach(Path path1, Path path2) throws IOException {
        // automatic resource management
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        }

        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        } // resources still close automatically
        catch (IOException e){ // optional clauses
            // exception handler
        } finally { // optional clauses
            // finally block
        }
    }

    public void scopeTest(){
        try(Scanner s = new Scanner(System.in)){
            s.nextLine();
        } catch (Exception e){
            // s.nexInt(); // DOES NOT COMPILE
        } finally {
            // s.nextInt(); // DOES NOT COMPILE
        }
    }

    public void autoCloseable(){
        // because Turkey1 doesn't implement AutoCloseable interface
        /*try(Turkey1 turkey1 = new Turkey1()){ // DOES NOT COMPILE
            System.out.print(turkey1);
        }*/
    }
}

class Turkey1 {}

class Turkey2 implements AutoCloseable{

    @Override
    public void close(){
        System.out.println("Close gate");
    }

    public static void main(String[] args) {
        try(Turkey2 turkey2 = new Turkey2()){
            System.out.println("put turkeys in");
        }
    }
}