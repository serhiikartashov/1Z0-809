package certification.chapter7.examples.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example2 {

    Semaphore binary = new Semaphore(1);

    public static void main(String args[]) {
        final Example2 test = new Example2();
        new Thread(){
            @Override
            public void run(){
                test.mutualExclusion();
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                test.mutualExclusion();
            }
        }.start();

    }

    private void mutualExclusion() {
        try {
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }
}
