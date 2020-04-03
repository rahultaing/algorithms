// https://www.youtube.com/watch?v=za2YuucS0tw
// https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;

public class Solution{

    public int compute(int[] trees){

        int n=trees.length;
        if (n==0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;
        int j=0;
        int max = 0;
        while (j<n){

            if (map.size() <= 2){
                map.put(trees[i], j);
                j++;
            }

            if (map.size()>2){
                int min=n-1;

                for (int idx: map.values()){
                    min = Math.min(min, idx);
                }

                i=min+1;
                map.remove(trees[min]);
            }

            max = Math.max(max, j-i);
        }

        return max;
    }
}