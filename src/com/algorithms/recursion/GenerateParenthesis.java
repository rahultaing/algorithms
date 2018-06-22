package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/description/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class GenerateParenthesis {

    private List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        this.recurse(n, 0, 0);
        return this.list;
    }

    private void recurse(Integer n, Integer lc, Integer rc){
        
    }
}
