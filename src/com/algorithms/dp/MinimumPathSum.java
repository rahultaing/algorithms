package com.algorithms.dp;

/*
* Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        Integer n = grid.length;

        if (n == 0){
            return 0;
        }

        Integer m = grid[0].length;
        Integer[][] dp = new Integer[n][m];

        for (Integer i = 0; i < n; i++){
            for (Integer j = 0; j < m; j++){

                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else if (i > 0 && j > 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
