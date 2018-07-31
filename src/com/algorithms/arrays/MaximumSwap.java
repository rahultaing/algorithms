package com.algorithms.arrays;

/*
https://leetcode.com/problems/maximum-swap/description/

* Given a non-negative integer, you could swap two digits at most once to get
* the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
*/
public class MaximumSwap {

    public int maximumSwap(int num) {

        char[] digits = String.valueOf(num).toCharArray();
        int[] lastPos = new int[10];

        int n = digits.length;

        for (int i=0; i<n; i++){
            lastPos[digits[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++){

            for (int j=9; j > digits[i]-'0'; j--){

                if (lastPos[j] > i){
                    char temp = digits[i];
                    digits[i] = digits[lastPos[j]];
                    digits[lastPos[j]] = temp;
                    return Integer.getInteger(digits.toString());
                }
            }
        }

        return num;
    }
}
