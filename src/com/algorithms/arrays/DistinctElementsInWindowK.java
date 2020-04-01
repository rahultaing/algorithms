// https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/

import java.util.Arrays;
import java.util.HashMap;

public class Solution{


    public void distinctElements(int[] nums, int k){

        for (int i = 0; i<nums.length-k; i++){
            this.compute(Arrays.copyOfRange(nums, i, nums.length), k);
        }
    }

    private void compute(int[] nums, int k){

        int dist = 0;

        for (int i =0; i<k; i++){

            int j=0;
            for (; j<i; j++){
                if (nums[i] == nums[j]){
                    break;
                }
            }

            if (i==j){
                dist++;
            }
        }

        System.out.println(dist);
    }

}

public class Solution2{

    HashMap<Integer, Integer> map = new HashMap<>();

    public void compute(int[] nums, int k){

        int dist = 0;
        for (int i=0; i<k; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                dist++;
                map.put(nums[i], 1);
            }
        }

        System.out.println(dist);

        for (int i=k; i<nums.length; i++){

            if (map.get(nums[i-k]) == 1){
                map.remove(nums[i-k]);
                dist--;
            }
            else{
                map.put(nums[i-k], map.get(nums[i-k])-1);
            }

            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                dist++;
                map.put(nums[i], 1);

            }

            System.out.println(dist);
        }
    }
}