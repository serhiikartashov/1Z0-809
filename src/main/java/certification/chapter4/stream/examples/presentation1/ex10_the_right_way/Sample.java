package certification.chapter4.stream.examples.presentation1.ex10_the_right_way;

import certification.chapter4.stream.examples.presentation1.common.Gender;
import certification.chapter4.stream.examples.presentation1.common.Person;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {
  public static List<Person> createPeople() {
    return Arrays.asList(
	    new Person("Sara", Gender.FEMALE, 20),
	    new Person("Sara", Gender.FEMALE, 22),
	    new Person("Bob", Gender.MALE, 20),
	    new Person("Paula", Gender.FEMALE, 32),
	    new Person("Paul", Gender.MALE, 32),
	    new Person("Jack", Gender.MALE, 2),
	    new Person("Jack", Gender.MALE, 72),
	    new Person("Jill", Gender.FEMALE, 12)
	  );
  }
  
	public static void main(String[] args) {
	  List<Person> people = createPeople();

    //list of all adult names in uppercase
    List<String> names = people.stream()
                               .filter(person -> person.getAge() > 17)
                               .map(Person::getName)
                               .map(String::toUpperCase)
                               .collect(
                                () -> new ArrayList<String>(),
                                (list, name) -> list.add(name),
                                (list1, list2) -> list1.addAll(list2));
          
   System.out.println(names);
   
   //Smelly, but illustrates some essential points.
   /*
    The collect takes three parameters:
      1. Supplier - the initial value for the reduction
      2. The accumulator - this takes an element and accumulates to the evolving result
      3. The combiner - this is useful during parallel execution, this can take two partial results and combine into one.
   */
   
   // Simplification
   List<String> names2 = people.stream()
                               .filter(person -> person.getAge() > 17)
                               .map(Person::getName)
                               .map(String::toUpperCase)
                               .collect(toList());
                              
    System.out.println(names2);
	}
}
