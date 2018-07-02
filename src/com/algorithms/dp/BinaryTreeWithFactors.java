package com.algorithms.dp;

/*
https://leetcode.com/articles/binary-trees-with-factors/

Given an array of unique integers, each integer is strictly greater than 1.

We make a binary tree using these integers and each number may be used for any number of times.

Each non-leaf node's value should be equal to the product of the values of it's children.

How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

Example 1:

Input: A = [2, 4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: A = [2, 4, 5, 10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

*/

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeWithFactors {

    public int numFactoredBinaryTrees(int[] A) {

        int MOD = 1_000_000_007;

        int n = A.length;
        Arrays.sort(A);
        if (n == 0){
            return 0;
        }

        long[] dp = new long[n];

        Arrays.fill(dp, 1);
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i=0; i<n; i++){
            map.put(A[i],i);
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){

                if (A[i] % A[j] == 0){
                    int k = A[i] / A[j];

                    if (map.containsKey(k)){
                        dp[i] += (dp[j] * dp[map.get(k)])%MOD;
                    }
                }
            }
        }

        for (int i=0; i<n; i++){
            ans += dp[i];
        }

        return ans%MOD;
    }
}
