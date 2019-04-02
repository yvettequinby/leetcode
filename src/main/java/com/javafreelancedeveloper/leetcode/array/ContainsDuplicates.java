package com.javafreelancedeveloper.leetcode.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ContainsDuplicates {

    @Test
    public void testIt1() {
        ContainsDuplicates sandbox = new ContainsDuplicates();
        int[] nums = {1,1,2};
        boolean result = sandbox.containsDuplicate(nums);
        assertEquals(true, result);
    }


    @Test
    public void testIt2() {
        ContainsDuplicates sandbox = new ContainsDuplicates();
        int[] nums = {1,2,3,4};
        boolean result = sandbox.containsDuplicate(nums);
        assertEquals(false, result);
    }


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueInts = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(!uniqueInts.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
