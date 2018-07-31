package com.algorithms.dp;

/*
*
* https://leetcode.com/problems/decode-ways/description/
* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

*/
public class DecodeWays {

    public int numDecodings(String s) {

        Integer n = s.length();

        if (n == 0){
            return 0;
        }

        Integer[] dp = new Integer[n+1];

        /*TODO: understand why dp[0] is 1? and why is dp of length n+1 instead of length n*/
        dp[0] = 1;

        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (Integer i=2; i<=n; i++){
            Integer v1 = Integer.valueOf(s.substring(i-1, i));
            Integer v2 = Integer.valueOf(s.substring(i-2, i));

            if (v1 <= 9 && v1 >= 1){
                dp[i] += dp[i-1];
            }

            if (v2 >= 10 && v2 <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
