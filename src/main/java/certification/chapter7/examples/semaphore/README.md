###Semaphore 

http://tutorials.jenkov.com/java-util-concurrent/semaphore.html

is used to control the number of concurrent threads that are using a resource. 
That resource can be something like a file, or could be the cpu by limiting the number of threads executing. 
The count on a Semaphore can go up and down as different threads call _acquire()_ and _release()_.

Use Semaphore to control thread access to resource.


###Semaphore Usage
As semaphore typically has two uses:

- To guard a critical section against entry by more than N threads at a time.
- To send signals between two threads.


###Guarding Critical Sections
If you use a semaphore to guard a critical section, the thread trying to enter the critical section will typically first try to acquire a permit, enter the critical section, and then release the permit again after. Like this:

    Semaphore semaphore = new Semaphore(1);
    
    //critical section
    semaphore.acquire();
    
    ...
    
    semaphore.release();

###Sending Signals Between Threads

If you use a semaphore to send signals between threads, then you would typically have one thread call the acquire() method, and the other thread to call the release() method.

If no permits are available, the acquire() call will block until a permit is released by another thread. Similarly, a release() calls is blocked if no more permits can be released into this semaphore.

Thus it is possible to coordinate threads. For instance, if acquire was called after Thread 1 had inserted an object in a shared list, and Thread 2 had called release() just before taking an object from that list, you had essentially created a blocking queue. The number of permits available in the semaphore would correspond to the maximum number of elements the blocking queue could hold.

**Mutex** class is old implementation of Semaphore from Java 1.4

