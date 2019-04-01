package com.javafreelancedeveloper.leetcode.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The key intuition to solve the problem is that given a number of stairs n,
 * if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2,
 * then the total ways to get to the point [n] is n1 + n2.
 * Because from the [n-1] point, we can take one single step to reach [n].
 * And from the [n-2] point, we could take two steps to get there.
 */
public class ClimbStairs {

    @Test
    public void testIt1() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(0);
        assertEquals(0, result);
    }

    @Test
    public void testIt2() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(1);
        assertEquals(1, result);
    }

    @Test
    public void testIt3() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(2);
        assertEquals(2, result);
    }

    @Test
    public void testIt4() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(3);
        assertEquals(3, result);
    }

    @Test
    public void testIt5() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(4);
        assertEquals(5, result);
    }

    @Test
    public void testIt6() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(5);
        assertEquals(8, result);
    }

    @Test
    public void testIt7() {
        ClimbStairs sandbox = new ClimbStairs();
        int result = sandbox.climbStairs(6);
        assertEquals(13, result);
    }


    public int climbStairs(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int allWays = 0;

        for (int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }
}
