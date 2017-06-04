package com.company.desingpatterns.strategypattern.oldfashion;

import com.company.desingpatterns.strategypattern.ActiveStrategy;
import com.company.desingpatterns.strategypattern.LazyStrategy;
import com.company.desingpatterns.strategypattern.Strategy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class StrategyPatternOldFashion {


  public static void main(String[] args) {
    List<Strategy> strategies =
        Arrays.asList(new LazyStrategy(),
            new ActiveStrategy()
        );

    for (Strategy strategy : strategies) {
      strategy.performTask();
    }
  }

}
