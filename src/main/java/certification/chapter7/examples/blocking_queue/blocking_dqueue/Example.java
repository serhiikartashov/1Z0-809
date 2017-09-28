package certification.chapter7.examples.blocking_queue.blocking_dqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    static BlockingDeque<String> bd = new LinkedBlockingDeque<String>(1);

    public static void main(String[] args) {
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Example bdeque = new Example();
        ElementReceive elementReceive = bdeque.new ElementReceive();
        ElementInsert elementInsert = bdeque.new ElementInsert();
        exService.execute(elementReceive);
        exService.execute(elementInsert);
        exService.shutdown();
    }

    class ElementReceive implements Runnable {
        @Override
        public void run() {
            for (; ; ) {
                try {
                    String s = bd.take();
                    System.out.println("Element received is: " + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class ElementInsert implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    bd.put("A" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
