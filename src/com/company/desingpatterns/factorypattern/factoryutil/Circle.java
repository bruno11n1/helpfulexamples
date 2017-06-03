package com.company.desingpatterns.factorypattern.factoryutil;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class Circle implements Shape {


  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }
}
