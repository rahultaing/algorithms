package com.algorithms.arrays;

/*
https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

* Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
Examples :

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120
*/
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
