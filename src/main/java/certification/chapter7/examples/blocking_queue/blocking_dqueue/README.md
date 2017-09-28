A **BlockingDeque** could be used if threads are both producing and consuming elements of the same queue. 
It could also just be used if the producing thread needs to insert at both ends of the queue, 
and the consuming thread needs to remove from both ends of the queue.


A thread will produce elements and insert them into either end of the queue. 
- If the deque is currently full, the inserting thread will be blocked until a removing thread takes an element out of the deque. 
- If the deque is currently empty, a removing thread will be blocked until an inserting thread inserts an element into the deque.



| Operation | Throws Exception | Special Value | Blocks      | Times Out                        |
| --------- | ---------------- | ------------- | ----------- | -------------------------------- |
| Insert    | addFirst(o)      | offerFirst(o) | putFirst(o) | offerFirst(o, timeout, timeunit) |
| Remove	| removeFirst(o)   | pollFirst()   | takeFirst() | pollFirst(timeout, timeunit)     |
| Examine	| getFirst()	   | peekFirst()   |             |                                  | 	


| Operation | Throws Exception | Special Value | Blocks      | Times Out                        |
| --------- | ---------------- | ------------- | ----------- | -------------------------------- |
| Insert    | addLast(o)       | offerLast(o)  | putLast(o)  | offerLast(o, timeout, timeunit)  |
| Remove	| removeLast(o)    | pollLast()    | takeLast()  | pollLast(timeout, timeunit)      |
| Examine	| getLast()	       | peekLast()    |             |                                  | 	


###BlockingDeque Implementations
 - LinkedBlockingDeque

