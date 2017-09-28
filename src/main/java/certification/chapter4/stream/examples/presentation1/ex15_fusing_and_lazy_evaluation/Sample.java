package certification.chapter4.stream.examples.presentation1.ex15_fusing_and_lazy_evaluation;

import certification.chapter4.stream.examples.presentation1.common.Gender;
import certification.chapter4.stream.examples.presentation1.common.Person;

import java.util.*;
import java.util.function.Function;
import static java.util.Comparator.*;
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
  
  public static boolean isOlderThan25(Person person) {
    System.out.println("Evaluating person " + person);
    return person.getAge() > 25;
  }
  
	public static void main(String[] args) {
	  List<Person> people = createPeople();

    //find any person whose name is four letters but is older than 25
    
    System.out.println(
      people.stream()
            .filter(Sample::isOlderThan25)
            .filter(person -> person.getName().length() == 4)
            .findAny());
            
    //Fusing - all the intermediate operations are combined and executed at once on each element
    //lazy - no work is done until and unless it's needed. Elements after paul were not evaluated.
    
    //To see lazy let's run the sequence again, but without the terminal operation.
    System.out.println("No work got done here");
    System.out.println(
      people.stream()
            .filter(Sample::isOlderThan25)
            .filter(person -> person.getName().length() == 4));
	}
}
