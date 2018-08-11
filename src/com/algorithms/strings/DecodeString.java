package com.algorithms.strings;

import java.util.Stack;

/*
* https://leetcode.com/submissions/detail/119404639/
*
* Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
 repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces,
 square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain
any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/
public class DecodeString {

    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        int n = s.length();

        if (n == 0){
            return "";
        }

        stack.push("");
        int count;

        for (int i=0; i<n; i++){

            if (Character.isDigit(s.charAt(i))){

                int start = i;
                while (i+1 < n && Character.isDigit(s.charAt(i+1))){
                    i++;
                }

                String val = s.substring(start, i+1);
                count = Integer.valueOf(val);
                countStack.push(count);
            }
            else if (s.charAt(i) == '['){

                stack.push("");
            }
            else if (s.charAt(i) == ']'){

                StringBuilder sb = new StringBuilder();
                count = countStack.pop();
                String val = stack.pop();

                for (int j=0; j<count; j++){
                    sb.append(val);
                }

                stack.push(stack.pop() + sb.toString());
            }
            else{
                stack.push(stack.pop() + s.charAt(i));
            }
        }

        return stack.pop();
    }
}
