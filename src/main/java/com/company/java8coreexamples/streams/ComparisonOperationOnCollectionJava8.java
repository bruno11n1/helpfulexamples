package com.company.java8coreexamples.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Grzegorz on 04-Jun-17.
 */
public class ComparisonOperationOnCollectionJava8 {

  public static void main(String[] args) {

    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
    System.out.println("Using Java 8: ");
    System.out.println("List: " + strings);
    long count = strings.stream()
        .filter(string -> string.isEmpty())
        .count();
    System.out.println("Empty strings: " + count);
    count = strings.stream()
        .filter(string -> string.length() == 3)
        .count();
    System.out.println("String of length 3: " + count);
    List<String> filtered = strings.stream()
        .filter(string -> !string.isEmpty())
        .collect(Collectors.toList());
    System.out.println("Filtered List: " + filtered);
    String mergedSting = strings.stream()
        .filter(string -> !string.isEmpty())
        .collect(Collectors.joining(", "));
    System.out.println("Merged Strings: " + mergedSting);
    List<Integer> squaresList = numbers.stream()
        .map(integer -> integer * integer)
        .distinct()
        .collect(Collectors.toList());
    System.out.println("Squares list: " + squaresList);
    System.out.println("Numbers list: " + integers);
    IntSummaryStatistics statistics = integers.stream()
        .mapToInt((x) -> x)
        .summaryStatistics();
    System.out.println("Highest number in List : " + statistics.getMax());
    System.out.println("Lowest number in List : " + statistics.getMin());
    System.out.println("Sum of all numbers : " + statistics.getSum());
    System.out.println("Average of all numbers : " + statistics.getAverage());
    System.out.println("Random Numbers: ");
    Random random = new Random();
    random.ints()
        .limit(10)
        .sorted()
        .forEach(System.out::println);
    count = strings.parallelStream()
        .filter(string -> string.isEmpty())
        .count();
    System.out.println("Empty Strings : " + count);





  }

}
