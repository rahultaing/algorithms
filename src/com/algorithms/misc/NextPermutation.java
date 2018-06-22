package com.algorithms.misc;

import com.algorithms.common.Utils;

public class NextPermutation {

    public void nextPermutation(Integer[] nums) {

        Integer n = nums.length;

        if (n<2){
            return;
        }

        Integer index = -1;
        for (Integer i=n-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if (index != -1){
            for (Integer i=n-1; i>index; i--){
                if (nums[i] > nums[index]){
                    Utils.swap(nums, index, i);
                    break;
                }
            }
        }
        else{
            Utils.reverse(nums, 0, n-1);
        }

        Utils.reverse(nums, index+1, n-1);
    }
}
