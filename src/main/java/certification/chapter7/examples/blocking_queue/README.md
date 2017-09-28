###BlockingQueue

represents a queue which is thread safe to put into, and take instances from.

A BlockingQueue has 4 different sets of methods for inserting, removing and examining the elements in the queue. Each set of methods behaves differently in case the requested operation cannot be carried out immediately. Here is a table of the methods:

| Operation | Throws Exception | Special Value | Blocks | Times Out                   |
| --------- | ---------------- | ------------- | ------ | --------------------------- |
| Insert    | add(o)           | offer(o)      | put(o) | offer(o, timeout, timeunit) |
| Remove	| remove(o)        | poll()	       | take()	| poll(timeout, timeunit)     |
| Examine	| element()	       | peek()	 	 

The 4 different sets of behaviour means this:

1. **Throws Exception**: 
If the attempted operation is not possible immediately, an exception is thrown.
2. **Special Value**: 
If the attempted operation is not possible immediately, a special value is returned (often true / false).
3. **Blocks**: 
If the attempted operation is not possible immedidately, the method call blocks until it is.
4. **Times Out**: 
If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer than the given timeout. Returns a special value telling whether the operation succeeded or not (typically true / false).

Examine - досліджувати

It is not possible to insert null into a BlockingQueue. If you try to insert null, the BlockingQueue will throw a NullPointerException.

BlockingQueue Implementations:

- ArrayBlockingQueue

ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array. That it is bounded means that it cannot store unlimited amounts of elements. There is an upper bound on the number of elements it can store at the same time. You set the upper bound at instantiation time, and after that it cannot be changed.

The ArrayBlockingQueue stores the elements internally in FIFO (First In, First Out) order. The head of the queue is the element which has been in queue the longest time, and the tail of the queue is the element which has been in the queue the shortest time.

- DelayQueue

The **DelayQueue** blocks the elements internally until a certain delay has expired.

- LinkedBlockingQueue

The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes). This linked structure can optionally have an upper bound (верхня межа) if desired. If no upper bound is specified, Integer.MAX_VALUE is used as the upper bound.

The LinkedBlockingQueue stores the elements internally in FIFO (First In, First Out) order. The head of the queue is the element which has been in queue the longest time, and the tail of the queue is the element which has been in the queue the shortest time.

        BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);
        
        bounded.put("Value");
        
        String value = bounded.take();

- PriorityBlockingQueue

The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules as the java.util.PriorityQueue class. You cannot insert null into this queue.

All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. The elements thus order themselves according to whatever priority you decide in your Comparable implementation.

- SynchronousQueue

The SynchronousQueue is a queue that can only contain a single element internally. A thread inseting an element into the queue is blocked until another thread takes that element from the queue. Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until a thread insert an element into the queue.
Good for synchronization two threads (see exchanger).

Good explanation  https://www.youtube.com/watch?v=nUYOGkh9XqE

http://javarticles.com/2016/06/java-synchronousqueue-example.html
http://stackoverflow.com/questions/1426754/linkedblockingqueue-vs-concurrentlinkedqueue





