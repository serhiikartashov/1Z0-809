package certification.exceptionsandassertions.multicatchhandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Serhii on 18.12.2015.
 */
public class TestClass1 {

    public static void main(String[] args) {
        // single catch handler
        try{
            throw new IOException();
        } catch (IOException f){
            ;
        } catch (NumberFormatException n){
            ;
        }

        // multi catch handler
        try{
            throw new IOException();
        } catch (IOException | NumberFormatException e){
            ;
        }

    }

    void myMethod(Connection con, String fileName) {
        /*try {
            File file = new File(fileName);
            FileInputStream fin = new FileInputStream(file);  // may throw FileNotFoundEx
            fin.read(); // IOException
            Statement stmt = con.createStatement(); // SQLException
        }*/
        /*
        catch (IOException| FileNotFoundException | SQLException e) { // fail to compile
            System.out.println(e.toString());
        }*/

        /*catch (FileNotFoundException| IOException | SQLException e) { // fail to compile
        // FileNotFoundException is a subclass of alternative IOException
            System.out.println(e.toString());
        }*/

        /*catch (IOException | SQLException e) { // will compile
            System.out.println(e.toString());
        }*/
    }

    // combining exceptions
    void method2 (int a){
        try{
            if (a>0)
            throw new IOException();
            throw new SQLException();
        }catch (SQLException e){}
        catch (IOException | NumberFormatException e){}
        //catch (IOException e1 | NumberFormatException e2){} // won't compile

        /*catch (IOException| SQLException e) {
            e = new FileNotFoundException();// Won’t compile; can’t reassign value
                                            //to variable e because it’s implicitly final.
        }*/
    }
}

class Exception1 extends IOException{
    public String info() {
        return "I'm Base Exception";
    }
}
class Exception2 extends Exception{
    public String info() {
        return "I'm Derived Exception";
    }
}
class TestVariableTypeInMultiCatch {
    public static void main(String args[]) {
        try {
            int a = 10;
            if (a <= 10)throw new Exception1();
            else throw new Exception2();
        }
        catch (Exception1 | Exception2 ex) {
            //System.out.println(ex.info()); // Won’t compile; class Exception doesn’t define method info.
        }
    }
}

// but when we use interface we'll avoid this compilation fail statement
interface IEx {
    String info();
}
class Exception11 extends IOException implements IEx{
    public String info() {
        return "I'm Base Exception";
    }
}
class Exception21 extends Exception implements IEx {
    public String info() {
        return "I'm Derived Exception";
    }
}
class TestVariableTypeInMultiCatch1 {
    public static void main(String args[]) {
        try {
            int a = 10;
            if (a <= 10)throw new Exception11();
            else throw new Exception21();
        }
        catch (Exception11 | Exception21 ex) { // variable ex is of intersection type with Exception and IEx
            System.out.println(ex.info());
        }
    }
}
