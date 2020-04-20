// https://leetcode.com/submissions/detail/148681870/

public class Solution{

    public int removeDups(int[] nums){

        int n = nums.length;

        if (n == 0){
            return 0;
        }

        int insertPos = 1;
        int i = 1;

        while (i < n){

            if (nums[i] != nums[insertPos-1]){

                nums[insertPos] = nums[i];
                insertPos++;
            }

            i++;
        }

        return insertPos;
    }
}