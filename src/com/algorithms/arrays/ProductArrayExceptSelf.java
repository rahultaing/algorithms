package com.algorithms.arrays;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        if (n == 0){
            return nums;
        }

        int[] res = new int[n];
        int p = 1;

        for (int i=0; i<n; i++){
            res[i] = p;
            p *= nums[i];
        }

        p = 1;

        for (int i=n-1; i>=0; i--){
            res[i] *= p;
            p *= nums[i];
        }

        return res;
    }
}