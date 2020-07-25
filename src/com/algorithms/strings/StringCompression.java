package com.algorithms.strings;

/*
https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.

*/
public class StringCompression {
    
    public int compress(char[] chars) {
        int write_index = 0, read_index = 0;

        while (read_index < chars.length){

            char current = chars[read_index];
            int count = 0;

            while (chars[read_index] == current && read_index < chars.length){
                read_index++;
                count++;
            }

            chars[write_index++] = current;

            if (count>1){

                for (char c: Integer.toString(count).toCharArray()){
                    chars[write_index++] = c;
                }
            }
        }

        return write_index;
    }

}