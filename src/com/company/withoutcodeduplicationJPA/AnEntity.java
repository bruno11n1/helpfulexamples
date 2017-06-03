package com.company.withoutcodeduplicationJPA;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class AnEntity <T>  {

  private String property;

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }
}
