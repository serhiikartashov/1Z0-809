equals rules:

1. It is reflexive: For any non-null reference	value	x,	
x.equals(x) should return true.

2. It is symmetric: For any non-null reference values x and	y,	
x.equals(y)	should	return	true if and	only if	y.equals(x)	returns	true.

3. It is transitive: For any non-null reference	values x, y, and z,	
if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z)	
should return true.

4. It is consistent: For any non-null reference	values x and y,	
multiple invocations of x.equals(y) consistently return true or consistently 
return false, provided no information used in equals comparisons 
on the objects is modified.

5. For any non-null reference value x, x.equals(null) should return false.


hashcode rules:
1. Within the same program, the	result of hashCode() must not change.

2. If equals() returns true	when called with two objects, calling 
hashCode() on each of those objects must return the same result.

3. If equals() returns false when called with two objects, calling 
hashCode() on each of those objects does not have to return a different result.

Also remember:
When using a hash-based Collection or Map such as HashSet, LinkedHashSet, 
HashMap, Hashtable, or WeakHashMap, make sure that the hashCode() of the 
key objects that you put into the collection never changes while the object 
is in the collection. 
The bulletproof way to ensure this is to make your keys **immutable**, 
which has also other benefits.