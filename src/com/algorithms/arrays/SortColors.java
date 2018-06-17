package com.algorithms.arrays;

import com.algorithms.common.Utils;

public class SortColors {
    public void sort(Integer[] nums){

        Integer l = 0;
        Integer r = nums.length-1;

        for (Integer i=l; i<=r; i++){

            while (nums[i] == 2 && i<r){
                Utils.swap(nums, i , r);
                r--;
            }

            while(nums[i] == 0 && i>l){
                Utils.swap(nums, i, l);
                l++;
            }
        }
    }
}
