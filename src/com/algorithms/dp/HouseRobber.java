/*
https://leetcode.com/problems/house-robber/submissions/ 
https://www.youtube.com/watch?v=gQzNp8gBn5k
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