#List

List methods:

![List methods](list.png)

##ArrayList:

1. is like resizable array
2. The main benefit of an ArrayList is that you can look up any 
element in constant time. Adding or removing an element is slower 
than accessing an element. This makes an ArrayList a good choice 
when you are reading more often than (or the same amount as) 
writing to the ArrayList

##LinkedList:

1. A LinkedList is special because it implements both List and Queue. 
It has all of the methods of a List. It also has additional methods 
to facilitate adding or removing from the beginning and/or end of the list. 
2. The main benefits of a LinkedList are that you can access, add, 
and remove from the beginning and end of the list in constant time. 
The tradeoff is that dealing with an arbitrary index takes linear time. 
This makes a LinkedList a good choice when you’ll be using it as Queue.


