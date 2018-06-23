package com.algorithms.strings;

/*

https://leetcode.com/problems/reverse-words-in-a-string/description/

Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string
should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

Follow up: For C programmers, try to solve it in-place in O(1) space.
*/

public class ReverseWords {
    public String reverseWords(String s) {

        int n = s.length();

        if (n == 0){
            return s;
        }

        int j = n;

        StringBuilder sb = new StringBuilder();

        for (int i = n-1; i >= 0; i--){

            if (s.charAt(i) == ' '){
                j=i;
            }
            else if (i == 0 || s.charAt(i-1) == ' '){

                if (sb.length() != 0){
                    sb.append(' ');
                }

                sb.append(s, i, j);
            }
        }

        return sb.toString();
    }
}
