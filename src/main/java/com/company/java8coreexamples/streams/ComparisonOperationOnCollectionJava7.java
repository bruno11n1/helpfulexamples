package com.company.java8coreexamples.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Grzegorz on 04-Jun-17.
 */
public class ComparisonOperationOnCollectionJava7 {

  public static void main(String[] args) {
    System.out.println("Using Java 7: .");
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    System.out.println("List: " + strings);
    long count = getCountEmptyStringUsingJava7(strings);
    System.out.println("Empty Strings: " + count);
    count = getCountLength3UsingJava7(strings);
    System.out.println("Strings of length 3: " + count);
    //Eliminate empty string
    List<String> filtered = deleteEmptyStringsUsingJava7(strings);
    System.out.println("Filtered List: " + filtered);
    //Eliminate empty string and join using comma.
    String mergedString = getMergedStringUsingJava7(strings, ", ");
    System.out.println("Merged String: " + mergedString);
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    //get list of square of distinct numbers
    List<Integer> squaresList = getSquares(numbers);
    System.out.println("Squares List: " + squaresList);
    List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

    System.out.println("List: " + integers);
    System.out.println("Highest number in List : " + getMax(integers));
    System.out.println("Lowest number in List : " + getMin(integers));
    System.out.println("Sum of all numbers : " + getSum(integers));
    System.out.println("Average of all numbers : " + getAverage(integers));
    System.out.println("Random Numbers: ");

    //print ten random numbers
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      System.out.println(random.nextInt());
    }
  }

  private static long getCountEmptyStringUsingJava7(List<String> strings) {
    int count = 0;
    for (String string : strings) {
      if (string.isEmpty()) {
        count++;
      }
    }
    return count;
  }

  private static long getCountLength3UsingJava7(List<String> strings) {
    int count = 0;
    for (String string : strings) {
      if (string.length() == 3) {
        count++;
      }
    }
    return count;
  }

  private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
    List<String> filteredList = new ArrayList<>();
    for (String string : strings) {
      boolean isNotEmptyString = !string.isEmpty();
      if (isNotEmptyString) {
        filteredList.add(string);
      }
    }
    return filteredList;
  }

  private static String getMergedStringUsingJava7(List<String> strings, String separator) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : strings) {
      boolean isNotEmptyString = !string.isEmpty();
      if (isNotEmptyString) {
        stringBuilder.append(string);
        stringBuilder.append(separator);
      }
    }
    String mergedString = stringBuilder.toString();
    return mergedString.substring(0, mergedString.length() - 2);
  }

  private static List<Integer> getSquares(List<Integer> numbers) {
    List<Integer> squareList = new ArrayList<>();
    for (Integer number : numbers) {
      Integer square = new Integer(number.intValue() * number.intValue());
      if (!squareList.contains(square)) {
        squareList.add(square);
      }
    }
    return squareList;
  }

  private static int getMax(List<Integer> numbers) {
    int max = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      Integer number = numbers.get(i);
      if (number.intValue() > max) {
        max = number.intValue();
      }
    }
    return max;
  }

  private static int getMin(List<Integer> numbers) {
    int min = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      Integer number = numbers.get(i);
      if (number.intValue() < min) {
        min = number.intValue();
      }
    }
    return min;
  }

  private static int getSum(List<Integer> numbers) {
    int sum = (int) (numbers.get(0));
    for (int i = 1; i < numbers.size(); i++) {
      sum += (int) numbers.get(i);
    }
    return sum;
  }

  private static int getAverage(List<Integer> numbers) {
    return getSum(numbers) / numbers.size();
  }
}
