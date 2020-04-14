package com.algorithms.dp;
/*https://www.youtube.com/watch?v=We3YDTzNXEk */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        Integer n = word1.length();
        Integer m = word2.length();

        Integer[][] dp = new Integer[n+1][m+1];

        for (Integer i=0; i<=n; i++){
            dp[i][0] = i;
        }

        for (Integer i=0; i<=m; i++){
            dp[0][i] = i;
        }

        for (Integer i=1; i<=n; i++){
            for (Integer j=1; j<=m; j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(
                            Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}
