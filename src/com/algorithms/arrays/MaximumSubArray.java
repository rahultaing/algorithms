package com.algorithms.arrays;


/*
https://leetcode.com/problems/maximum-subarray/description/
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
which is more subtle.
*/

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        Integer n = nums.length;

        if (n==0){
            return 0;
        }

        Integer maxEndingHere = nums[0];
        Integer maxSoFar = nums[0];

        for (Integer i=1; i<n; i++){

            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
