package com.javafreelancedeveloper.leetcode.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProfit {

    @Test
    public void testIt1() {
        MaxProfit sandbox = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = sandbox.maxProfit(prices);
        assertEquals(5, result);
    }

    @Test
    public void testIt2() {
        MaxProfit sandbox = new MaxProfit();
        int[] prices = {7, 6, 5, 4};
        int result = sandbox.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    public void testIt3() {
        MaxProfit sandbox = new MaxProfit();
        int[] prices = {1, 2};
        int result = sandbox.maxProfit(prices);
        assertEquals(1, result);
    }


    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int b = 0; b < prices.length; b++) {
            int buyPrice = prices[b];
            for (int s = b + 1; s < prices.length; s++) {
                int sellPrice = prices[s];
                int profit = sellPrice - buyPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;

    }
}
