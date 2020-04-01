package com.algorithms.dp;

import java.util.HashSet;

/*
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true

https://leetcode.com/problems/word-break/

https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways

https://www.youtube.com/watch?v=WepWFGxiwRs&t=831s
*/

public class WordBreak {

    public boolean wordBreak(String s, HashSet<String> wordDict) {

        Integer n = s.length();
        Boolean[] dp = new Boolean[n+1];

        dp[0] = true;

        for (Integer i=1; i<=n; i++){

            for (Integer j=i-1; j>=0; j--){

                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
