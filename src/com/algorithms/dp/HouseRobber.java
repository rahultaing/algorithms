/*
https://leetcode.com/problems/house-robber/submissions/ 
https://www.youtube.com/watch?v=gQzNp8gBn5k

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
             
*/

public class Solution{

    public int rob(int[] nums){

        int n = nums.length;

        if (n==0){
            return 0;
        }

        if (n==1){
            return nums[0];
        }

        if (n==2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n+1];

        for (int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[n];
    }
}


public class Solution2 {
    public int rob(int[] nums) {
         int n = nums.length;

            if (n == 0)
                return 0;

            int i = 0;
            int a = 0;
            int b = 0;
            
            while (i < n)
            {
                if (i % 2 == 0)
                {
                    a = Math.max(a + nums[i], b);    
                }
                else
                {
                    b = Math.max(a, b + nums[i]);
                }
                
                i++;
            }
            
            return Math.max(a,b);
    }
}