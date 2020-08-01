package com.algorithms.strings;

import java.util.HashMap;

/*

https://leetcode.com/problems/string-transforms-into-another-string/discuss/355382/JavaC%2B%2BPython-Need-One-Unused-Character


Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

 

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.
  */


public class TransformString {
    
    public boolean canConvert(String str1, String str2) {
    
        HashMap<Character, Character> map = new HashMap<>();

        if (str1.equals(str2)){
            return true;
        }

        if (str1.length() != str2.length()){
            return false;
        }

        for (int i=0; i<str1.length(); i++){

            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)){
                return false;
            }

            map.put(str1.charAt(i), str2.charAt(i));
        }

        return new HashSet<Character>(map.values()).size() < 26;
    }
}