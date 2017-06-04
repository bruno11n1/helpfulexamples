package com.company.desingpatterns.factorypattern.factoryutil;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class ShapeFactory {

  public Shape getShape(String shapeType){
    if (shapeType == null){
      return  null;
    }
    if (shapeType.equalsIgnoreCase("CIRCLE")){
      return new Circle();
    }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
      return new Rectangle();
    }
    return null;
  }
}
