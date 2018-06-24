package com.algorithms.dp;

/*

https://leetcode.com/problems/maximum-product-subarray/description/

Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int n = nums.length;

        if (n == 0){
            return 0;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++){
            int a = maxProd;
            int b = minProd;

            /*
            * maxProd = either the number by itself, or a previous max times the number
            * or a previous min times the number
            * minProd = either the number by itself, or a previous min times the number
             * or a previous max times the number*/
            maxProd = Math.max(Math.max(a * nums[i], b * nums[i]), nums[i]);
            minProd = Math.min(Math.min(a * nums[i], b * nums[i]), nums[i]);

            max = Math.max(max, maxProd);
        }

        return max;
    }

}
