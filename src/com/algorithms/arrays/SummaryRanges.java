package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/summary-ranges/description/
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();

        int n = nums.length;

        if (n == 0){
            return list;
        }

        if (n == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        for (int i=0; i<n; i++){

            int v = nums[i];

            while(i<n-1 && nums[i+1]-nums[i]==1){
                i++;
            }

            if (nums[i] == v){
                list.add(String.valueOf(nums[i]));
            }
            else{
                list.add(v + "->" + nums[i]);
            }
        }

        return list;
    }

}
