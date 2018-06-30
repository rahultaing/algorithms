package com.algorithms.misc;

/*
https://leetcode.com/submissions/detail/117714908/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

*/

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        int n = s.length();
        StringBuilder[] sbArray = new StringBuilder[numRows];

        for (int i=0; i<numRows; i++){
            sbArray[i] = new StringBuilder();
        }

        int index = 0;

        while (index < n){

            for (int i = 0; i < numRows; i++){
                if (index < n){
                    sbArray[i].append(s.charAt(index));
                    index++;
                }
            }

            for (int i = numRows - 2; i > 0; i--){
                if (index < n){
                    sbArray[i].append(s.charAt(index));
                    index++;
                }
            }
        }

        for (int i = 1; i < numRows; i++){
            sbArray[0].append(sbArray[i]);
        }

        return sbArray[0].toString();
    }
}
