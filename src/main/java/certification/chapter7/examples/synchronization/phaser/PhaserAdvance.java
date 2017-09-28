package certification.chapter7.examples.synchronization.phaser;

import java.util.concurrent.Phaser;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class PhaserAdvance extends Phaser {

    PhaserAdvance(int parties){
        super(parties);
    }

    // Overriding the onAdvance method
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("In onAdvance method, current phase which is completed is " + phase );
        // Want to ensure that phaser runs for 2 phases i.e. phase 1
        // or the no. of registered parties become zero
        if(phase == 1 || registeredParties == 0){
            System.out.println("phaser will be terminated ");
            return true;
        }else{
            System.out.println("phaser will continue ");
            return false;
        }
    }

    public static void main(String... args) {
        // crating phaser instance
        PhaserAdvance ph = new PhaserAdvance(1);
        // creating three threads
        new TestThread("thread-1", ph);
        new TestThread("thread-2", ph);
        new TestThread("thread-3", ph);

        while(!ph.isTerminated()){
            ph.arriveAndAwaitAdvance();
        }
        System.out.println("In main method, phaser is terminated");
    }
}

class TestThread implements Runnable {
    private String threadName;
    private Phaser ph;

    TestThread(String threadName, Phaser ph){
        this.threadName = threadName;
        this.ph = ph;
        // register new unarrived party to this phaser
        ph.register();
        new Thread(this).start();
    }
    @Override
    public void run() {
        // be in the loop till the phaser is terminated
        while(!ph.isTerminated()){
            System.out.println("This is phase " + ph.getPhase() + " And Thread - "+ threadName);
            // Using await and advance so that all thread wait here
            ph.arriveAndAwaitAdvance();
        }

    }
}
