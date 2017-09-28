package certification.jvm;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Launcher implements Serializable {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
//            Thread.sleep(500);
//            System.out.println(LocalDateTime.now());
//            LocalDateTime.now();
            print();
        }
    }


    private static void print(){
        LocalDateTime.now();
    }
}
