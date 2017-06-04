package com.company.desingpatterns.strategypattern.java8fashion;

import com.company.desingpatterns.strategypattern.Strategy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class StrategyPatternJava8StaticMethods {

  public static void main(String[] args) {
    System.out.println("Strategy pattern with using of Lambdas!!");

    List<Strategy> strategies =
        Arrays.asList(
            Strategy.activeStrategy(),
            Strategy.lazyStrategy()
        );
    strategies.forEach((strategy) -> strategy.performTask());
  }
}
