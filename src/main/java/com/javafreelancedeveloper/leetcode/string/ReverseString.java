package com.javafreelancedeveloper.leetcode.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseString {

    @Test
    public void testIt() {
        ReverseString sandbox = new ReverseString();
        char[] input = {'h', 'e', 'l', 'l', 'o', 's'};
        char[] expectedOutput = {'s', 'o', 'l', 'l', 'e', 'h'};
        sandbox.reverseString(input);
        for (int i = 0; i < 6; i++) {
            assertEquals(expectedOutput[i], input[i]);
        }
    }

    public void reverseString(char[] s) {
        int swap = s.length - 1;
        for (int i = 0; i <= swap; i++) {
            char swapMe = s[i];
            char swapWith = s[swap];
            s[i] = swapWith;
            s[swap] = swapMe;
            swap--;
        }
    }
}
