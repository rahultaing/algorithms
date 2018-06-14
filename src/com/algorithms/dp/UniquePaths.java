package com.algorithms.dp;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        Integer[][] dp = new Integer[m][n];
        dp[0][0] = 1;

        for (Integer i=0; i < m; i++){
            for(Integer j=0; j<n; j++){

                if (i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }

                if (i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
