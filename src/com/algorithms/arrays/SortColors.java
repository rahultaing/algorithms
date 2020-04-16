package com.algorithms.arrays;

import com.algorithms.common.Utils;

/*

https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's,
then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

/*Time complexity: O(n)*/

/*last practiced date: 7/6/2018*/

public class SortColors {
    public void sort(Integer[] nums){

        Integer l = 0;
        Integer r = nums.length-1;

        int i=0;
        
        //was - for (Integer i=l; i<=r; i++)
        while (i<=r){
            while (nums[i] == 2 && i<r){
                Utils.swap(nums, i , r);
                r--;
            }

            while(nums[i] == 0 && i>l){
                Utils.swap(nums, i, l);
                l++;
            }

            i++;
        }
    }
}
