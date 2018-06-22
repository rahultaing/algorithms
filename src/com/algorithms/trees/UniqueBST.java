package com.algorithms.trees;

public class UniqueBST {

    public int numTrees(int n) {

        Integer[] dp = new Integer[n+1];

        dp[0] = dp[1] = 1;

        for (Integer i=2; i<=n; i++){
            for (Integer j=1; j<=i; j++){

                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
