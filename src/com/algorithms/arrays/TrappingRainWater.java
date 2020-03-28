// https://leetcode.com/problems/trapping-rain-water/solution/

public class Solution{

    public int trappingRainWater(int[] height){

        int l = 0;
        int r = height.length-1;

        int total = 0;

        int left_max = 0;
        int right_max = 0;

        while(l<r){

            if (height[l] < height[r]){

                left_max = Math.max(left_max , height[l]);
                total += left_max > height[l] ? left_max - height[l] : 0;
                l++;
            }
            else{

                right_max = Math.max(right_max, height[r]);
                total += right_max > height[r] ? right_max - height[r] : 0; 
                r--;
            }
        }

        return total;
    }
}