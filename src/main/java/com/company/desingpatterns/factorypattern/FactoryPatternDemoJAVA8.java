package com.company.desingpatterns.factorypattern;

import com.company.desingpatterns.factorypattern.factoryutil.ShapeFactory;
import java.util.function.Supplier;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class FactoryPatternDemoJAVA8 {

  public static void main(String[] args){
    Supplier<ShapeFactory> shapeFactory = ShapeFactory::new;
    shapeFactory.get().getShape("circle").draw();
    shapeFactory.get().getShape("rectangle").draw();
  }

}
