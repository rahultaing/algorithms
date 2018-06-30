package com.algorithms.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons)
is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/
public class LetterCombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {

        int n = digits.length();

        if (n == 0){
            return new ArrayList<>();
        }

        /*TODO: complete this string[]*/
        String[] numsToStr = {"", "", "abc", "def"};

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < n; i++){

            int count = queue.size();
            int digit = digits.charAt(i) - '0';
            String strAtDigit = numsToStr[digit];

            for (int j = 0; j < count; j++){

                String item = queue.poll();

                for (int k = 0; k < strAtDigit.length(); k++){
                    String newString = item + strAtDigit.charAt(k);
                    queue.add(newString);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
