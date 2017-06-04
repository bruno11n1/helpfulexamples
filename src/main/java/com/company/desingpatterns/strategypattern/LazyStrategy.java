package com.company.desingpatterns.strategypattern;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class LazyStrategy implements Strategy {

  @Override
  public void performTask() {
    System.out.println("Perform task a day before deadline!!");
  }
}
