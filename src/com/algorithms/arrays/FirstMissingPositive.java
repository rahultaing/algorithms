package com.algorithms.arrays;

import com.algorithms.common.Utils;

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
