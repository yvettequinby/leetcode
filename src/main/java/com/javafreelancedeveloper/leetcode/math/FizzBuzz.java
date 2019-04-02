package com.javafreelancedeveloper.leetcode.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzz {


    @Test
    public void testIt1() {
        FizzBuzz sandbox = new FizzBuzz();
        List<String> result = sandbox.fizzBuzz(5);
        List<String> expectedResult = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
        for (int i = 0; i < 5; i++) {
            assertEquals(expectedResult.get(i), result.get(i));
        }
    }


    @Test
    public void testIt2() {
        FizzBuzz sandbox = new FizzBuzz();
        List<String> result = sandbox.fizzBuzz(15);
        List<String> expectedResult = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        for (int i = 0; i < 5; i++) {
            assertEquals(expectedResult.get(i), result.get(i));
        }
    }


    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
