package com.algorithms.arrays;

import com.algorithms.common.Utils;

/*
https://leetcode.com/problems/first-missing-positive/description/

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

TODO: determine time complexity
*/
public class FirstMissingPositive {

    public Integer find(Integer[] nums){

        Integer n = nums.length;

        for (Integer i=0; i<n; i++) {

            /*this while loop is the trickiest part of the problem*/
            while(nums[i]>0 && nums[i]<=n && nums[nums[i] - 1]!=nums[i]){
                Utils.swap(nums, nums[i] - 1, i);
            }
        }

        for (Integer i=0; i<n; i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }

        return n+1;
    }
}
