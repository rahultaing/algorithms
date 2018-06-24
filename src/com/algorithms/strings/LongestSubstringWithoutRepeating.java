package com.algorithms.strings;

/*

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        if (n == 0){
            return 0;
        }

        int max = 0;
        int j = 0;

        for (int i=0; i<n; i++){

            if (map.containsKey(s.charAt(i))){

                /*NOTES: the reason why j is set to max of j and map.get(s.charAt(i)) + 1
                can be explained by taking an example of abba. When i=3, j is set to 2.
                If we just use map.get(s.charAt(i)) + 1 we will set j to 1 instead it should be
                set to 2. That's why its necessary to use the max of j and map.get(s.charAt(i)) + 1
                */
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }

        return max;
    }
}
