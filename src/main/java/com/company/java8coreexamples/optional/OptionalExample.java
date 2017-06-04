package com.company.java8coreexamples.optional;

import java.util.Optional;

/**
 * Created by Grzegorz on 04-Jun-17.
 */
public class OptionalExample {


  public static void main(String[] args) {
    OptionalExample optionalExample = new OptionalExample();
    Integer firstValue = null;
    Integer secondValue = new Integer(10);

    //Optional.ofNullable - allows passed parameter to be null.
    Optional<Integer> first = Optional.ofNullable(firstValue);

    //Optional.of - throws NullPointerException if passed parameter is null
    Optional<Integer> second = Optional.of(secondValue);
    System.out.println(optionalExample.sum(first, second));
  }

  private Integer sum(Optional<Integer> first, Optional<Integer> second) {
    //Optional.isPresent - checks the value is present or not
    System.out.println("First parameter is present: " + first.isPresent());
    System.out.println("Second parameter is present: " + second.isPresent());
    //Optional.orElse - returns the value if present otherwise returns
    //the default value passed.
    Integer firstValue = first.orElse(new Integer(0));
    //Optional.get - gets the value, value should be present
    Integer secondValue = second.get();
    return firstValue + secondValue;
  }


}
