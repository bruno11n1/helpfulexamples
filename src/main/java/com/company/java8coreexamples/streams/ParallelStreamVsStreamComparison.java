package com.company.java8coreexamples.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gk on 6/5/2017.
 */
public class ParallelStreamVsStreamComparison {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }

//        Processing data Sequentially
        long startTime = System.currentTimeMillis();
        numbers.stream()
                .forEach(integer -> processElement(integer));
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000;
        System.out.println("Time taken with stream() : " + timeTaken + " milliseconds");

//        Processing data in parallel
        startTime = System.currentTimeMillis();
        numbers.parallelStream()
                .forEach(integer -> processElement(integer));
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime) / 1000;
        System.out.println("Time taken with parallelStream() : " + timeTaken + " milliseconds");


    }

    private static void processElement(int integer) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
