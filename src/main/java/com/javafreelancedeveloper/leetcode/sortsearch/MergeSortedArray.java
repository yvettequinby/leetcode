package com.javafreelancedeveloper.leetcode.sortsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSortedArray {

    @Test
    public void testIt() {
        MergeSortedArray sandbox = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        sandbox.merge(nums1, m, nums2, n);
        int[] expectedResult = {1, 2, 2, 3, 5, 6};
        for (int i = 0; i < 6; i++) {
            assertEquals(expectedResult[i], nums1[i]);
        }
    }

    @Test
    public void testIt2() {
        MergeSortedArray sandbox = new MergeSortedArray();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        sandbox.merge(nums1, m, nums2, n);
        int[] expectedResult = {1};
        for (int i = 0; i < 1; i++) {
            assertEquals(expectedResult[i], nums1[i]);
        }
    }

    @Test
    public void testIt3() {
        MergeSortedArray sandbox = new MergeSortedArray();
        int[] nums1 = {1, 0};
        int m = 1;
        int[] nums2 = {2};
        int n = 1;
        sandbox.merge(nums1, m, nums2, n);
        int[] expectedResult = {1, 2};
        for (int i = 0; i < 2; i++) {
            assertEquals(expectedResult[i], nums1[i]);
        }
    }

    @Test
    public void testIt4() {
        MergeSortedArray sandbox = new MergeSortedArray();
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        sandbox.merge(nums1, m, nums2, n);
        int[] expectedResult = {1, 2};
        for (int i = 0; i < 2; i++) {
            assertEquals(expectedResult[i], nums1[i]);
        }
    }

    @Test
    public void testIt5() {
        MergeSortedArray sandbox = new MergeSortedArray();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        sandbox.merge(nums1, m, nums2, n);
        int[] expectedResult = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            assertEquals(expectedResult[i], nums1[i]);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Size = m;
        int lastMerge = 0;
        for (int i = 0; i < n; i++) {
            int mergeMe = nums2[i];
            int mergeAt = -1;
            for (int k = lastMerge; k < nums1Size; k++) {
                int mergeAgainst = nums1[k];
                if (k == 0 && mergeAgainst >= mergeMe) {
                    mergeAt = k;
                    break;
                } else if (mergeAgainst <= mergeMe && nums1[k + 1] > mergeMe) {
                    mergeAt = k + 1;
                    break;
                }
            }
            if (mergeAt >= 0) {
                bump(mergeAt, nums1, nums1Size);
                nums1[mergeAt] = mergeMe;
                nums1Size++;
                lastMerge = mergeAt;
            } else {
                nums1[nums1Size] = mergeMe;
                nums1Size++;
                lastMerge = nums1Size;
            }

        }
    }

    private void bump(int bumpFrom, int[] nums1, int nums1Size) {
        if (bumpFrom < nums1Size) {
            int bumpMe = nums1[bumpFrom];
            for (int i = bumpFrom + 1; i < nums1.length; i++) {
                int nextBumpMe = nums1[i];
                nums1[i] = bumpMe;
                bumpMe = nextBumpMe;
            }
        }

    }
}
