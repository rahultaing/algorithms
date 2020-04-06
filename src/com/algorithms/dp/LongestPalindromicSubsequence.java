/*https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java */

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

                Integer j = i+l-1;

                if (l==2 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2;
                }else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }


    public int longestPalindromicSubsequence(String s){

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        for (int d=1; d<n; d++){
            for (int i=0; i<n-d; i++){

                int j= i+d;

                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
