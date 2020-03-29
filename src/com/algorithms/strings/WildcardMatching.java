package com.algorithms.strings;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
*/

/*TODO: determine time complexity*/

// this is a much better solution using dp https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int s1 = 0;
        int p1 = 0;
        int starIndex = -1;
        int match = 0;

        while (s1 < s.length()){

            if (p1 < p.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '?')){
                s1++;
                p1++;
            }
            else if (p1 < p.length() && p.charAt(p1) == '*'){
                starIndex = p1;
                match = s1;
                p1++;
            }
            else if (starIndex != -1){
                p1 = starIndex + 1;
                match++;
                s1 = match;
            }
            else {
                return false;
            }
        }

        while (p1 < p.length() && p.charAt(p1) == '*') {
            p1++;
        }

        return p1 == p.length();
    }

    // dp way of doing it
    public boolean isMatch(String s, String p){

        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();

        int writeIndex = 0;
        boolean isFirst = true;
        for (int i=0; i<p.length() ; i++){

            if (pa[i] == '*'){
                if (isFirst){
                    pa[writeIndex++] = pa[i];
                    isFirst = false;
                }
            }
            else {
                pa[writeIndex++] = pa[i];
                isFirst = true;
            }
        }

        boolean[][] dp = new boolean[s.length()+1][writeIndex+1];

        dp[0][0] = true;
        if (writeIndex > 0 && pa[0] == '*'){
                dp[0][1] = true;
        }

        for (int i=1; i<=s.length(); i++){

            for (int j=1; j<=writeIndex; j++){

                if (sa[i] == pa[i] || pa[i] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pa[j] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[s.length()][writeIndex];
    }
}
