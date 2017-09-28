###Fail-Fast vs Fail-Save

A system is called **fail-fast** if it is shut down immediately when an error occurred. 
These systems don’t carry on with the errors. They immediately stop operating when a fault 
is occurred in the system. The errors in the fail-fast systems are immediately exposed. 
But, **fail-safe** systems are not like that. They don’t stop operating even when a fault 
is occurred in the system. They continue the operation by hiding the errors. 
They don’t expose the errors immediately. They carry on with the errors. 
Which one is the best system is always the most discussed topic in the system design field.

###ConcurrentHashMap

The The ConcurrentHashMap is very similar to the java.util.HashTable class, except that ConcurrentHashMap offers better concurrency than HashTable does. ConcurrentHashMap does not lock the Map while you are reading from it. Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. It only locks the part of the Map that is being written to, internally.

Another difference is that ConcurrentHashMap does not throw ConcurrentModificationException if the ConcurrentHashMap is changed while being iterated. The Iterator is not designed to be used by more than one thread though.
