package certification.chapter7.creation;

/**
 * Created by Serhii K. on 3/4/2016.
 */
public class PrintData implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    }

    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}
