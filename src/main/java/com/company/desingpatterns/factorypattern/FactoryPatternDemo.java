package com.company.desingpatterns.factorypattern;

import com.company.desingpatterns.factorypattern.factoryutil.Shape;
import com.company.desingpatterns.factorypattern.factoryutil.ShapeFactory;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class FactoryPatternDemo {

  public static void main(String[] args){
    ShapeFactory shapeFactory = new ShapeFactory();

    Shape shape1 = shapeFactory.getShape("CIRCLE");

    shape1.draw();

    Shape shape2 = shapeFactory.getShape("RECTANGLE");

    shape2.draw();
  }

}
