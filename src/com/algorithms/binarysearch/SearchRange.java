package com.algorithms.binarysearch;

/*
*https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *  Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

/*Time complexity: O(log N)
* last practiced date: 7/11/2018*/
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        Integer start = this.search(nums, target);

        if (start == nums.length || nums[start] != target){
            return new int[] {-1, -1};
        }

        Integer end = this.search(nums, target+1);
        return new int[]{start, end-1};
    }

    private int search(int[] nums, int target){

        int lo = 0;
        int hi = nums.length-1;

        while(lo < hi){

            int mid = lo + (hi-lo)/2;

            if (nums[mid] < target){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }

        return lo;
    }
}
