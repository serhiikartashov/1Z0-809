package certification.chapter4.stream.examples.presentation1.ex14_sorting_with_comparators;

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
  
	public static void main(String[] args) {
	  List<Person> people = createPeople();
    
    System.out.println("---------------");
    people.stream()
           .sorted((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1)
          .forEach(System.out::println);

    
    System.out.println("---------------");
    Function<Person, Integer> byAge = Person::getAge;
    people.stream()
          .sorted(comparing(byAge))
          .forEach(System.out::println);


    System.out.println("---------------");
    Function<Person, String> byName = Person::getName;
    people.stream()
          .sorted(comparing(byAge).thenComparing(byName))
          .forEach(System.out::println);
	}
}
