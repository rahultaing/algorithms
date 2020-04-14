package com.algorithms.dp;

// https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class RodCutting {

    public int cutRod(int[] prices){

        int n = prices.length;
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i=1; i<=n; i++){

            for (int j=0; j<i; j++){

                dp[i] = Math.max(dp[i], prices[j] + dp[i-j-1]);
            }
        }

        return dp[n];
    }
}