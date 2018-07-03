package com.algorithms.dp;

import com.algorithms.common.Utils;

public class LongestRepeatedSubsequence {

    public int lrs(String s){
        int n = s.length();

        if (n == 0){
            return 0;
        }

        int[][] dp = new int[n+1][n+1];

        /*This calculates the length*/
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){

                if (i==0 || j==0){
                    dp[i][j] = 0;
                }
                else{
                    if (s.charAt(i) == s.charAt(j) && i!=j){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        /*This will print the string*/
        int i=n;
        int j=n;
        while (i>0 && j>0){

                if (dp[i][j] == dp[i-1][j-1] + 1){
                    sb.append(s.charAt(i-1));
                    i--;
                    j--;
                }
                else {
                    if (dp[i][j] == dp[i-1][j]){
                        i--;
                    }
                    else{
                        j--;
                    }
                }
        }

        Utils.reverse(sb.toString(), 0, sb.length());
        return dp[n][n];
    }
}
