package com.algorithms.trees;

import java.util.Stack;

public class VerifyPreorderSerialization {

    public boolean isValidSerialization(String preorder) {

        if (preorder.length() == 0){
            return true;
        }

        String[] sa = preorder.split(",");
        Integer n = sa.length;
        Stack<String> stack = new Stack<>();

        for (Integer i=0; i<n; i++){

            /*most convoluted logic ever. logically your mind will never be able to write this naturally.*/
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
