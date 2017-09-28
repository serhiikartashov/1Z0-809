package certification.chapter4.stream.examples.presentation1.ex17_parallel_streams;

import certification.chapter4.stream.examples.presentation1.common.Gender;
import certification.chapter4.stream.examples.presentation1.common.Person;

import java.util.*;
import java.util.stream.Stream;

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

  public static void printFirstPersonOlderThan25(Stream<Person> people) {
    System.out.println(
      people.filter(Sample::isOlderThan25)
            .findFirst());
  }

  public static void printAnyPersonOlderThan25(Stream<Person> people) {
    System.out.println(
      people.filter(Sample::isOlderThan25)
            .findAny());    
  }
  
	public static void main(String[] args) {
	  List<Person> people = createPeople();


    System.out.println("Running sequential....");
    System.out.println("      Find First");
    printFirstPersonOlderThan25(people.stream());

    System.out.println("      Find Any");
    printAnyPersonOlderThan25(people.stream());
    
    
    System.out.println("Running parallel....");
    System.out.println("      Find First");
    printFirstPersonOlderThan25(people.parallelStream());

    System.out.println("      Find Any");
    printAnyPersonOlderThan25(people.parallelStream());
    
    //Run many times to see that the result of the last operation is not consistently the same.
    //We care about one of the results, not a particular result.
    //The idea is we are willing to expend all avaialble resource to get the result faster.
	}
}
