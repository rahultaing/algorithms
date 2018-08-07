package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* Count distinct elements in every window of size k

https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/


* */
public class CountDistinctInWindowK {

    List<Integer> countDistinct(int[] nums, int k){
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        if (n < k){
            return list;
        }

        int distinctCount = 0;

        for (int i=0; i<k; i++){

            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
                distinctCount++;
            }
        }

        list.add(distinctCount);

        for (int i=k; i<n; i++){

            int toRemoveVal = nums[i-k];

            if (map.get(toRemoveVal) == 1){
                distinctCount--;
                map.remove(toRemoveVal);
            }
            else{
                map.put(toRemoveVal, map.get(toRemoveVal) - 1);
            }

            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
                distinctCount++;
            }

            list.add(distinctCount);
        }

        return list;
    }
}
