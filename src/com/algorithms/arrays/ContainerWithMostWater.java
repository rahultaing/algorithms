// https://leetcode.com/problems/container-with-most-water/solution/

public class Solution{

    public class compute(int[] height){

        int maxArea=0,l=0,r=height.length-1;

        while(l<r){

            maxArea = Math.max(maxArea, Math.min([r], height[l]) * r-l);
            if (height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return maxArea;
    }
}