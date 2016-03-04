package certification.chapter7.creation;

/**
 * Created by Serhii K. on 3/4/2016.
 */
public class ReadInventoryThread extends Thread {

    @Override
    public void run() {
        System.out.println("printing something");
    }

    public static void main(String[] args) {
        //(new ReadInventoryThread()).start();

        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");
    }
}
