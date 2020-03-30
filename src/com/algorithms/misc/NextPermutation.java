/*https://leetcode.com/problems/next-permutation/ 


https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia

*/

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
            int i=n-1;
            for (; i>index; i--){
                if (nums[i] > nums[index]){
                    Utils.swap(nums, index, i);
                    break;
                }
            }
            
            Utils.reverse(nums, index+1, n-1);
        }
        else{
            Utils.reverse(nums, 0, n-1);
        }
    }
}
