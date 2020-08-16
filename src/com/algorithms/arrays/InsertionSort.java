import com.algorithms.common.Utils;

public class Solution{

    public void sort(int[] nums){

        int n = nums.length;

        for (int i=1; i<n; i++){
            int j = i-1;
            int key = nums[i];

            while (j>=0 && nums[j] > key){

                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }
    }

    // better solution

    public void sort(int[] nums){

        for (int i=1; i<nums.length; i++){
            int j = i-1;
            int key = nums[];
            while (j>=0 && nums[j] > key){

                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }
    }
}