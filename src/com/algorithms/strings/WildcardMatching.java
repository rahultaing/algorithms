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
}
