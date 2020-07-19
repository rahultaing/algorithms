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

            if (nums[mid]>nums[mid+1] && nums[mid]<nums[mid-1]){
                return mid+1;
            }

            if (nums[mid] > nums[l]){
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

// this solution is much better. copied from approach #2 here 
// https://leetcode.com/problems/search-in-rotated-sorted-array/solution/

public class Solution2{

    public int search(int[] nums, int target) {
     
        int start = 0, end = nums.length - 1;

        while (start < end){

            int mid = start + (end-start)/2;

            if (nums[mid] == target){
                return mid;
            }

            // from start to mid is not rotated i.e. increasing
            if (nums[start]<nums[mid]){
                if (target > nums[start] && target < nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            // from mid to end is not rotated i.e. increasing
            else if (nums[end] > nums[mid]){
                
                if (target < nums[end] && target > nums[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}