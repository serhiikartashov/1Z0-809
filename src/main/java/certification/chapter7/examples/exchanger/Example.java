package certification.chapter7.examples.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // instead of object exchanger may exchange lists (caches).
        // but more preferably to use in algorithms
        // alternatives: ArrayBlockingQueues
        ExchangerRunnable exchangerRunnable1 =
                new ExchangerRunnable(exchanger, "A");

        ExchangerRunnable exchangerRunnable2 =
                new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}

class ExchangerRunnable implements Runnable {

    Exchanger<String> exchanger = null;
    String object = null;

    public ExchangerRunnable(Exchanger<String> exchanger, String object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;

            this.object = this.exchanger.exchange(this.object);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged " + previous + " for " + this.object
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
