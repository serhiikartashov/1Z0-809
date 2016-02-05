package certification.chapter2.design_patterns.singleton;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class StaffRegister {
    private static final StaffRegister instance;

    /*
     *  If our singleton is accessed thousands of times over many hours
     *	or days, this means that only the first few calls would require
     *	synchronization, and the rest would not.
     */
    // private static volatile final StaffRegister instance;

    static {
        instance = new StaffRegister();
    }

    private StaffRegister(){}
    public static StaffRegister getInstance(){
        return instance;
    }

    // other methods
}

// lazy instantiation
class VisitorTicketTracker {
    private static VisitorTicketTracker instance;
    private VisitorTicketTracker(){}
    public static VisitorTicketTracker getInstance(){
        if (instance==null){
            instance = new VisitorTicketTracker(); // NOT THREAD-SAFE
        }
        /*// For volatile member
        synchronized (VisitorTicketTracker.class){
            if (instance==null){
                instance = new VisitorTicketTracker(); // NOT THREAD-SAFE
            }
        }*/
        return instance;
    }

    /*public static synchronized VisitorTicketTracker getInstance(){
        if (instance==null){
            instance = new VisitorTicketTracker(); // THREAD-SAFE
        }
        return instance;
    }*/
}
