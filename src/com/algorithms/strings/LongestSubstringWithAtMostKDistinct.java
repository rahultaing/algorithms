package com.algorithms.strings;

/*
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinct {
    
    private HashMap<Character, Integer> map = new HashMap<>();
    private int max_len;

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int end=0, start=0;

        while (end < s.length()){

            map.put(s.charAt(end), end);
            end++;

            if (map.size()>k){

                int min_index = Collections.min(map.values());
                map.remove(s.charAt(min_index));
                start = min_index+1;
            }

            max_len = Math.max(max_len, end-start);
        }

        return max_len;
    }

}