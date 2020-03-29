// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Solution {
    private int[] nums;
    private int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int rotated_index = this.find_rotated_index();

        if (rotated_index == 0){
            return this.search(0, nums.length -1);
        }

        if (target<nums[0]){
            return this.search(rotated_index, nums.length -1);
        }
        else {
            return this.search(0, rotated_index);
        }
    }

    private int find_rotated_index(){

        int l = 0;
        int r = nums.length -1;

        while (l<r){

            int mid = l+(r-l)/2;

            if (nums[mid]>nums[mid+1]){
                return mid+1;
            }

            if (nums[mid] > nums[0]){
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }

        return 0;
    }

    private int search(int l, int r){

        while (l<r){

            int mid=l+(r-l)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (target > nums[mid]){

                l=mid+1;
            }
            else {

                r=mid-1;
            }
        }

        return -1;
    }
}