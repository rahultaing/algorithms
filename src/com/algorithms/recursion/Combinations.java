package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/description/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Combinations {

    private List<List<Integer>> outList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        int[] A = new int[n+1];
        int[] B = new int[n+1];

        for (int i=1; i<=n; i++){
            A[i] = i;
        }

        this.recurse(A, B, n, 1, k);
        return this.outList;
    }

    private void recurse(int[] A, int[] B, int n, int index, int k){

        if (index == n){
            B[index] = 0;
            this.print(A, B, n, k);
            B[index] = 1;
            this.print(A, B, n, k);
        }
        else{
            B[index] = 0;
            this.recurse(A, B, n, index+1, k);
            B[index] = 1;
            this.recurse(A, B, n, index+1, k);
        }
    }

    private void print(int[] A, int[] B, int n, int k){

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            if (B[i] == 1){
                list.add(A[i]);
            }
        }

        if (list.size() == k){
            this.outList.add(list);
        }
    }
}
