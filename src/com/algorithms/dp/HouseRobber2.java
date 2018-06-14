package com.algorithms.dp;

public class HouseRobber2 {

    public Integer rob(int[] nums){

        Integer n = nums.length;

        if (n == 0){
            return 0;
        }

        if (n == 1){
            return nums[0];
        }

        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(this.rob(nums, 0, n-2), this.rob(nums, 1 ,n-1));
    }

    private Integer rob(int[] nums, int l, int r){

        int a = 0;
        int b = 0;

        int i = l;

        while (i <= r){
            if (i % 2 == 0){

                a = Math.max(b, a + nums[i]);
            }else{

                b = Math.max(a, b + nums[i]);
            }

            i++;
        }

        return Math.max(a, b);
    }
}
