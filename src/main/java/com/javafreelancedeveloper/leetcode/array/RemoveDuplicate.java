package com.javafreelancedeveloper.leetcode.array;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicate {

    @Test
    public void testIt() {
        RemoveDuplicate sandbox = new RemoveDuplicate();
        int[] nums = {1,1,2};
        Integer result = sandbox.removeDuplicates(nums);
        Integer expectedResult = 2;
        int[] expectedNums = {1,2};
        assertEquals(expectedResult, result);

        for(int i=0; i<expectedResult; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();
        for(int i=0; i<nums.length; i++) {
            unique.add(nums[i]);
        }
        int i=0;
        for(Integer u : unique) {
            nums[i] = u;
            i++;
        }
        return i;

    }
}
