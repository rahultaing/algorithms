package com.algorithms.dp;

public class LongestPalindromicSubsequence {

    public Integer findLongest(String s){
        Integer n = s.length();

        Integer[][] dp = new Integer[n][n];

        for (Integer i=0; i<n; i++){
            dp[i][i] = 1;
        }

        /*TODO: indexes are incorrect. it is not clear why i runs till n-l+1 and j = i+l
        * The mathematical calculation is unclear*/
        for (Integer l = 2; l < n; l++){
            for (Integer i = 0; i < n-l+1; i++){

                Integer j = i+l;

                if (l==2 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2;
                }else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
