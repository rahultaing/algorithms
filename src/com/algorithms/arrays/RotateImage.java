package com.algorithms.arrays;

/*
https://leetcode.com/problems/rotate-image/description/

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/

/*
last practiced date: 7/4/2018
*/

public class RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        if (n == 0){
            return;
        }

        int start = 0;
        int end = n-1;

        while(start < end){
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
