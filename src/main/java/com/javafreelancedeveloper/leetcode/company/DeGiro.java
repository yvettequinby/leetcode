package com.javafreelancedeveloper.leetcode.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeGiro {

    private final Integer holandFlutSalePrice = 10;
    private final int maxResultSize = 10;


    @Test
    public void testAnalyseFlutStack1() {
        int[] b = {12, 3, 10, 7, 16, 5};
        StackProfitResult daMoney = analyseFlutStack(6, b);
        assertEquals(8, daMoney.getProfit().intValue());
        assertEquals(Arrays.asList(4), daMoney.getBoxCountList());
    }


    @Test
    public void testAnalyseFlutStack2() {
        int[] b = {7, 3, 11, 9, 10};
        StackProfitResult daMoney = analyseFlutStack(5, b);
        assertEquals(10, daMoney.getProfit().intValue());
        assertEquals(Arrays.asList(2, 4, 5), daMoney.getBoxCountList());
    }


    @Test
    public void testAnalyseFlutStack3() {
        int[] b = {1, 2, 3, 4, 10, 16, 10, 4, 16};
        StackProfitResult daMoney = analyseFlutStack(9, b);
        assertEquals(30, daMoney.getProfit().intValue());
        assertEquals(Arrays.asList(4, 5, 8), daMoney.getBoxCountList());
    }


    @Test
    public void testAnalyseFlutStack4() {
        int[] b = {11};
        StackProfitResult daMoney = analyseFlutStack(1, b);
        assertEquals(0, daMoney.getProfit().intValue());
        assertEquals(0, daMoney.getBoxCountList().size());
    }

    @Test
    public void testAnalyseFlutStacks1() {
        StackDescription sd1 = new StackDescription(5, new int[]{7, 3, 11, 9, 10});
        StackDescription sd2 = new StackDescription(9, new int[]{1, 2, 3, 4, 10, 16, 10, 4, 16});
        StackProfitResult daMoney = analyseFlutStacks(Arrays.asList(sd1, sd2));
        assertEquals(40, daMoney.getProfit().intValue());
        assertEquals(Arrays.asList(6, 7, 8, 9, 10, 12, 13), daMoney.getBoxCountList());
    }


    private StackProfitResult analyseFlutStacks(List<StackDescription> stackDescriptions) {

        List<StackProfitResult> stackResults = new ArrayList<>();

        Integer profit = 0;

        for(StackDescription stackDescription : stackDescriptions) {
            StackProfitResult stackProfitResult = analyseFlutStack(stackDescription.stackSize, stackDescription.stack);
            if(stackProfitResult.profit>0) {
                stackResults.add(stackProfitResult);
                profit = profit + stackProfitResult.getProfit();
            }
        }

        // TODO: recursive permutation madness

        return new StackProfitResult(profit, new ArrayList<Integer>());

    }


    private StackProfitResult analyseFlutStack(int stackSize, int[] flutCostStack) {

        List<Integer> maxProfitBoxCountList = new ArrayList<>(); // the result for this stack

        Integer cumulativeProfit = 0;
        Integer maxProfit = 0;

        for (int i = 0; i < stackSize; i++) {

            Integer individualFlutProfit = holandFlutSalePrice - flutCostStack[i]; // profit for just this flut
            Integer stackedFlutProfit = cumulativeProfit + individualFlutProfit; // profit for the stack up to and including this flut

            if (stackedFlutProfit > maxProfit) { // check if this is a better profit
                maxProfitBoxCountList = new ArrayList<>(); // reset list of
                maxProfitBoxCountList.add(i + 1); // add box count to list
                maxProfit = stackedFlutProfit; // keep track of the best profit
            } else if (stackedFlutProfit.equals(maxProfit)) { // check if it is the max profit
                if (maxProfitBoxCountList.size() < maxResultSize) { // no point going over total size limit
                    maxProfitBoxCountList.add(i + 1); // add to list of box counts with this profit
                }
            }

            cumulativeProfit = stackedFlutProfit; // keep track cumulative stack profit

        }

        return new StackProfitResult(maxProfit, maxProfitBoxCountList);

    }


    private class StackDescription {

        private final int stackSize;
        private final int[] stack;


        private StackDescription(int stackSize, int[] stack) {
            this.stackSize = stackSize;
            this.stack = stack;
        }

        public int getStackSize() {
            return stackSize;
        }

        public int[] getStack() {
            return stack;
        }

    }

    private class StackProfitResult {

        private final Integer profit;
        private final List<Integer> boxCountList;


        private StackProfitResult(Integer profit, List<Integer> boxCountList) {
            this.profit = profit;
            this.boxCountList = boxCountList;
        }

        public Integer getProfit() {
            return profit;
        }

        public List<Integer> getBoxCountList() {
            return boxCountList;
        }
    }
}
