package com.algorithms.trees;

import java.util.Stack;

/*
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
* One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal
 serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never
contain two consecutive commas such as "1,,3".

Example 1:
Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true


Example 2:
Input: "1,#"
Output: false


Example 3:
Input: "9,#,#,1"
Output: false
*/
public class VerifyPreorderSerialization {

    public boolean isValidSerialization(String preorder) {

        if (preorder.length() == 0){
            return true;
        }

        String[] sa = preorder.split(",");
        Integer n = sa.length;
        Stack<String> stack = new Stack<>();

        for (Integer i=0; i<n; i++){

            /*most convoluted logic ever. logically your mind will never be able to write this naturally.
            *
            * The best way to understand this logic is to walk through this Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
             * on paper.*/
            while (sa[i].equals("#") && !stack.empty() && stack.peek().equals("#")){
                stack.pop();

                if (stack.isEmpty()){
                    return false;
                }

                stack.pop();
            }

            stack.push(sa[i]);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}


public class Solution{

    public boolean isValidSerialization(String preorder){

        int n = preorder.length();
        int slots = 1;

        for (int i=0; i<n; i++){
            if (preorder.charAt(i)==','){
                slots--;

                if (slots < 0){
                    return false;
                }

                if (preorder.charAt(i-1) != '#'){
                    slots += 2;
                }
            }
        }

        slots = preorder.charAt(n-1) != '#' ? slots+1: slots-1;

        return slots == 0;
    }
}