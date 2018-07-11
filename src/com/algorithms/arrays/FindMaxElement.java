package com.algorithms.arrays;

public class FindMaxElement {

    public int findMax(int[] nums){
        int n = nums.length;

        if (n == 0){
            return 0;
        }

        if (n==1){
            return nums[0];
        }

        if (n==2){
            return nums[0]>nums[1] ? nums[0] : nums[1];
        }

        return this.binarySearch(nums, 0, n-1);
    }

    private int binarySearch(int[] nums, int l, int r){

        int mid = l + (r-l)/2;

        if ((mid == 0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
            return nums[mid];
        }

        if (mid > 0 && nums[mid] < nums[mid-1]){
            return this.binarySearch(nums, l, mid-1);
        }

        return this.binarySearch(nums, mid+1, r);
    }
}
