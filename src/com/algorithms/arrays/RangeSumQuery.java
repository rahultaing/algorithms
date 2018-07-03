package com.algorithms.arrays;

/*
https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
public class RangeSumQuery {

    private int[] numsArray;
    public RangeSumQuery(int[] nums) {

        this.numsArray = nums;
        Integer n = nums.length;

        for (Integer i=1; i<n; i++){
            this.numsArray[i] += this.numsArray[i-1];
        }
    }

    public int sumRange(int i, int j) {

        if (i==0){
            return this.numsArray[j];
        }
        else{
            return this.numsArray[j] - this.numsArray[i-1];
        }
    }
}
