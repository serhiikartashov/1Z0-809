package certification.chapter7.examples.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example4 {

    private static final int MAX_CONCURRENT_THREADS = 4;
    private final Semaphore crunchifyAdminLOCK = new Semaphore(MAX_CONCURRENT_THREADS, true);

    public void crunchifyStartTest() {
        for (int i = 0; i < 10; i++) {
            CrunchifyPerson person = new CrunchifyPerson();
            person.start();
        }
    }

    public class CrunchifyPerson extends Thread {
        @Override
        public void run() {
            try {

                // Acquire Lock
                crunchifyAdminLOCK.acquire();
            } catch (InterruptedException e) {
                System.out.println("received InterruptedException");
                return;
            }
            System.out.println("Thread " + this.getId() + " start using Crunchify's car - Acquire()");
            try {
                sleep(1000);
            } catch (Exception e) {

            } finally {

                // Release Lock
                crunchifyAdminLOCK.release();
            }
            System.out.println("Thread " + this.getId() + " stops using Crunchify's car -  Release()\n");
        }
    }

    public static void main(String[] args) {
        Example4 test = new Example4();
        test.crunchifyStartTest();

    }
}
