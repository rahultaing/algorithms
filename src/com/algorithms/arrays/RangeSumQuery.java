package com.algorithms.arrays;

public class RangeSumQuery {

    private int[] numsArray;
    public RangeSumQuery(int[] nums) {

        this.numsArray = nums;
        Integer n = nums.length;

        for (Integer i=1; i<n; i++){
            this.numsArray[i] += this.numsArray[i-1];
        }
    }

    public int sumRange(int i, int j) {

        if (i==0){
            return this.numsArray[j];
        }
        else{
            return this.numsArray[j] - this.numsArray[i-1];
        }
    }
}
