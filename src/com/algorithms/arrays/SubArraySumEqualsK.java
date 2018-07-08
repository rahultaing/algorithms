package com.algorithms.arrays;

import java.util.HashMap;

/*
https://leetcode.com/articles/subarray-sum-equals-k/

Given an array of integers and an integer k, you need to find
 the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

*/

/*last practiced date : 7/6/2018*/
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Integer n = nums.length;
        map.put(0,1);

        Integer count = 0;
        Integer sum = 0;

        /*TODO: read/write explanation of this logic from the above article.*/
        for (Integer i=0; i<n; i++){

            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            Integer val = sum-k;

            if (map.containsKey(val)){
                count += map.get(val);
            }
        }

        return count;
    }
}
