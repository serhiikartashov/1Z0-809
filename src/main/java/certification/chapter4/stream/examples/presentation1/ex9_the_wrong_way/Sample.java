package certification.chapter4.stream.examples.presentation1.ex9_the_wrong_way;

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
    List<String> names = new ArrayList<>();

    people.stream()
          .filter(person -> person.getAge() > 17)
          .map(Person::getName)
          .map(String::toUpperCase)
          .forEach(names::add); //DON'T DO THIS
          
  
   //causes side-effect, interfering, mutating, ugly, smelly, dangerous, can't make this concurrent.
          
   System.out.println(names);
	}
}
