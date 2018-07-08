package com.algorithms.arrays;

import java.util.HashSet;

/*
https://leetcode.com/problems/longest-consecutive-sequence/description/

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;

        if (n == 0){
            return 0;
        }

        int max = 0;

        for (int i : nums){
            set.add(i);
        }

        for (Integer i : set){

            if (!set.contains(i-1)){

                int m = i+1;

                while (set.contains(m)){
                    m++;
                }

                max = Math.max(max, m-i);
            }
        }

        return max;
    }
}
