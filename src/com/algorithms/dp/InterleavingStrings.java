package com.algorithms.dp;

/*
https://leetcode.com/problems/interleaving-string/description/

* Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/

public class InterleavingStrings {

    public Boolean isInterleaving(String s1, String s2, String s3){

        if (s3.length() != s1.length() + s2.length()){
            return false;
        }

        Integer n = s1.length();
        Integer m = s2.length();

        Boolean[][] dp = new Boolean[n+1][m+1];

        for (Integer i=0; i<=n; i++){
            for (Integer j=0; j<=m; j++){

                if (i==0 && j==0){
                    dp[i][j] = true;
                }
                else if (i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
                else if (j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                else{
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])
                            || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
