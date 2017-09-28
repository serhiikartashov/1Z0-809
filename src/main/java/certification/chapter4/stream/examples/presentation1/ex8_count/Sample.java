package certification.chapter4.stream.examples.presentation1.ex8_count;

import certification.chapter4.stream.examples.presentation1.common.Gender;
import certification.chapter4.stream.examples.presentation1.common.Person;

import java.util.*;

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

    System.out.println(
      people.stream()
            .filter(person -> person.getAge() < 18)
            .count());
	}
}
