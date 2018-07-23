package com.algorithms.dp;

/*
https://www.geeksforgeeks.org/longest-common-subsequence/

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program
that outputs the differences between two files), and has applications in bioinformatics.

last practiced date: 7/15/2018
*/

public class LongestCommonSubsequence {

    public int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        if (n == 0 || m == 0){
            return 0;
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){

                if (i==0 || j==0){
                    dp[i][j] = 0;
                }
                else{

                    if (s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
