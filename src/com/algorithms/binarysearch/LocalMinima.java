package com.algorithms.binarysearch;

/*time complexity: O(log N)*/

/*last practiced date: 7/8/2018*/

public class LocalMinima {

    public Integer findLocalMinima(Integer[] nums){

       return this.findLocalMinima(nums, 0, nums.length-1);
    }

    private Integer findLocalMinima(Integer[] nums, Integer l, Integer r){
        Integer mid = l + (r-l)/2;

        if ((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
            return nums[mid];
        }

        if (nums[mid]>nums[mid-1] && mid>0){
            return this.findLocalMinima(nums, l, mid-1);
        }

        return this.findLocalMinima(nums, mid+1, r);
    }
}
