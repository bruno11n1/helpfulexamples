package com.company.desingpatterns.strategypattern;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public interface Strategy {

  public void performTask();

  static Strategy lazyStrategy() {
    return () -> System.out.println("Perform task a day before deadline!!");
  }

  static Strategy activeStrategy() {
    return () -> System.out.println("Perform task now!!");
  }

}
