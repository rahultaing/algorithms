package com.algorithms.arrays;
/*https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/
public class LongestIncreasingPath {
    // dfs

    private int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int[][] cache;
    private int max = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        cache = new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                this.max = Math.max(this.max, this.dfs(i,j,n,m,matrix));
            }
        }

        return this.max;
    }

    private int dfs(int i, int j, int n, int m, int[][] matrix){

        if (cache[i][j] != 0){
            return cache[i][j];
        }

        for (int k=0; k<dir.length; k++){
            int newi = i + dir[k][0];
            int newj = j + dir[k][1];

            if (newi<0 || newi>=n || newj<0 || newj>=m || matrix[i][j]>matrix[newi][newj]){
                continue;
            }

            cache[i][j] = Math.max(cache[i][j], dfs(newi, newj, n, m, matrix) + 1);
        }

        return cache[i][j];
    }
}


public class LongestIncreasingPath2 {

    // PQ + DP
    public int longestIncreasingPath(int[][] matrix) {
        
    }
}