package com.algorithms.misc;

/*

https://leetcode.com/problems/multiply-strings/description/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[] prod = new int[n+m];

        for (int i=n-1; i>=0; i--){
            for (int j=m-1; j>=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + prod[p2];

                /*p1 is the carry forward*/
                prod[p1] += sum/10;
                prod[p2] = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int p: prod){
            if (!(sb.length()==0 && p==0)){
                sb.append(String.valueOf(p));
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
