package certification.chapter4.stream.examples.presentation1.ex16_infinite_streams;

import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Prime {
  private static boolean isPrime(int number) {
    return number > 1 && 
      IntStream.range(2, number)
               .noneMatch(index -> number % index == 0);
  }
  
  private static int getNext(int number) {
    if(isPrime(number + 1))
      return number + 1;
    else
      return getNext(number + 1);
  }
  
  public static Stream<Integer> getPrimesFrom(int start) {
    return Stream.iterate(getNext(start - 1), Prime::getNext);
  }
}

public class Sample {
  public static void printNPrimesFrom(int count, int from) {
    System.out.println(count + " primes from " + from);

	  System.out.println(
	    Prime.getPrimesFrom(from)
	         .limit(count)
	         .collect(toList()));
  }
  
	public static void main(String[] args) {
	  printNPrimesFrom(10, 1);
	  printNPrimesFrom(5, 100);
	}
}
