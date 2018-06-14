package com.algorithms.binarysearch;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        /*TODO: the SearchInsertPosition code goes out of bounds for this
         * see how you can fix SearchInsertPosition so that it can be
          * reused here.*/
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        Integer start = searchInsertPosition.search(nums, target);

        if (start == nums.length || nums[start] != target){
            return new int[] {-1, -1};
        }

        Integer end = searchInsertPosition.search(nums, target+1);
        return new int[]{start, end-1};
    }
}
