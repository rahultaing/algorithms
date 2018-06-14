package com.algorithms.binarysearch;

/*https://leetcode.com/problems/search-insert-position/discuss/15080/My-8-line-Java-solution*/
public class SearchInsertPosition {

    public Integer search(int[] nums, Integer val){

        Integer lo = 0;
        Integer hi = nums.length - 1;

        while (lo < hi){
            Integer mid = lo + (hi-lo)/2;

            if (nums[mid] == val){
                return mid;
            }

            if (nums[mid] > val){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}
