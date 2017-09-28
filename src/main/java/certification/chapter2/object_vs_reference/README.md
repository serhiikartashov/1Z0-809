All objects are accessed by reference, so as a developer you never have direct access to the 
memory of the object itself.

```

Lemur lemur = new Lemur();
Object lemurAsObject = lemur;

```

Two	rules:

1. The type of the object determines which properties exist within 
the object in memory. 
2. The type	of the reference to the object determines which methods 
and variables are accessible to the Java program.
