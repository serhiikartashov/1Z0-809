package certification.chapter7.examples.synchronization.phaser;

import java.util.concurrent.Phaser;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser ph = new Phaser(1);
        // Threads for first phase
        new FileReaderThread("thread-1", "file-1", ph);
        new FileReaderThread("thread-2", "file-2", ph);
        new FileReaderThread("thread-3", "file-3", ph);
        int curPhase;
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        // This will be the second phase where
        // threads are deregistered from the phaser
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        // Threads for third phase
        new QueryThread("thread-1", 40, ph);
        new QueryThread("thread-2", 40, ph);
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");
        // deregistering the main thread
        ph.arriveAndDeregister();
    }
}

class FileReaderThread implements Runnable {
    private String threadName;
    private String fileName;
    private Phaser ph;

    FileReaderThread(String threadName, String fileName, Phaser ph) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.ph = ph;
        ph.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Reading file " + fileName + " thread " + threadName + "parsing and storing to DB ");
        // Using await and advance so that all thread wait here
        ph.arriveAndAwaitAdvance();
        try {
            // Just for creating some delay, not
            // actually required
            Thread.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Deregistering");
        ph.arriveAndDeregister();
    }
}

class QueryThread implements Runnable {
    private String threadName;
    private int param;
    private Phaser ph;

    QueryThread(String threadName, int param, Phaser ph) {
        this.threadName = threadName;
        this.param = param;
        this.ph = ph;
        ph.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Querying DB using param " + param + " Thread " + threadName);
        ph.arriveAndAwaitAdvance();
    }
}
