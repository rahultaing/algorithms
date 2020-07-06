package com.algorithms.dp;
/*https://www.youtube.com/watch?v=We3YDTzNXEk 

https://leetcode.com/problems/edit-distance/

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/
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
