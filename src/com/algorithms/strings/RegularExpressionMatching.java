package com.algorithms.strings;

/*
https://leetcode.com/problems/regular-expression-matching/description/
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

*/

/*TODO: determine time complexity of this algorithm.*/
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            return this.isMatch(s, p.substring(2)) ||
                    (s.length() > 0 &&
                            this.isMatch(s.substring(1), p) &&
                            (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)));
        }

        if (p.charAt(0) == '.'){
            return s.length() > 0 && this.isMatch(s.substring(1), p.substring(1));
        }

        return s.length() > 0 && this.isMatch(s.substring(1), p.substring(1));
    }
}
