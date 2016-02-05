#Singleton Pattern

##Problem 
How do we create an object in memory only once in an application and 
have it shared by multiple classes? 

##Motivation 
There are times when we want only one instance of a particular type 
of object in memory. For example, we might want to manage the amount 
of hay available for food to the zoo animals across all classes that 
use it. We could pass the same shared HayManager object to every 
class and method that uses it, although this would create a lot of 
extra pointers and could be difficult to manage if the object is 
used throughout the application. By creating a singleton HayManager 
object, we centralize the data and remove the need to pass it around 
the application. 

##Solution 
The singleton pattern is a creational pattern focused on creating 
only one instance of an object in memory within an application, 
sharable by all classes and threads within the application. 
The globally available object created by the singleton pattern is 
referred to as a singleton. Singletons may also improve performance 
by loading reusable data that would otherwise be time consuming to 
store and reload each time it is needed. 

#Immutable Object

##Problem 
How do we create read-only objects that can be shared and used by 
multiple classes? 

##Motivation 
Sometimes we want to create simple objects that can be shared across 
multiple classes, but for security reasons we don’t want their value 
to be modified. We could copy the object before sending it to another 
method, but this creates a large overhead that duplicates the object 
every time it is passed. Furthermore, if we have multiple threads 
accessing the same object, we could run into concurrency issues, 
as you will see in Chapter 7. 

##Solution 
The immutable object pattern is a creational pattern based on the 
idea of creating objects whose state does not change after they 
are created and can be easily shared across multiple classes. 
Immutable objects go hand and hand with encapsulation, except that 
no setter methods exist that modify the object. Since the state of 
an immutable object never changes, they are inherently thread-safe.

Rules:

1. Use a constructor to set all properties of the object. 
2. Mark all of the instance variables private and final. 
3. Don’t define any setter methods. 
4. Don’t allow referenced mutable objects to be modified or 
accessed directly. 
5. Prevent methods from being overridden. 

#Builder

##Problem 
How do we create an object that requires numerous values to be set 
at the time the object is instantiated?

##Motivation
As our data objects grow in size, the constructor may grow to contain 
many attributes. For example, in our most recent immutable Animal 
class example, we had three input parameters: species, age, and 
favoriteFoods. If we want to add five new attributes to the object, 
we’d have to add five new values in the constructor. Every time we add 
a parameter, the constructor grows! Users who reference our object 
would also be required to update their constructor calls each time 
that the object was modified, resulting in a class that would be 
difficult to use and maintain. Alternatively, we could add a new 
constructor each time we add a parameter, but having too many 
constructors can be quite difficult to manage in practice.

##Solution
The builder pattern is a creational pattern in which parameters are 
passed to a builder object, often through method chaining, and an object 
is generated with a final build call. It is often used with immutable 
objects, since immutable objects do not have setter methods and must 
be created with all of their parameters set, although it can be used 
with mutable objects as well.


#Factory

##Problem 
How do we write code that creates objects in which the precise type 
of the object may not be known until runtime? 

##Motivation 
As you saw with the builder pattern, object creation can be quite 
complex. We’d like some way of encapsulating object creation to deal 
with the complexity of object creation, including selecting which 
subclass to use, as well as loosely coupling the underlying creation 
implementation. 

##Solution 
The factory pattern, sometimes referred to as the factory method 
pattern, is a creational pattern based on the idea of using a 
factory class to produce instances of objects based on a set of 
input parameters. It is similar to the builder pattern, although 
it is focused on supporting class polymorphism.


