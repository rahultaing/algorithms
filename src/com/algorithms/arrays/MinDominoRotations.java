/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

Algorithm

Pick up the first element. It has two sides: A[0] and B[0].

Check if one could make all elements in A row or B row to be equal to A[0]. If yes, return the minimum number of rotations needed.

Check if one could make all elements in A row or B row to be equal to B[0]. If yes, return the minimum number of rotations needed.

Otherwise return -1.

 */

public class Solution{

    private int n;
    public int minDominoRotations(int[] A, int[] B){

        n = A.length;
        int result = compute(A, B, A[0]);
        
        if (result != -1){
            return result;
        }

        return compute(A, B, B[0]);
    }

    private int compute(int[] A, int[] B, int val){

        int min_rotationsA=0;
        int min_rotationsB=0;

        for (int i=0; i<n; i++){

            if (A[i] != val && B[i] != val){
                return -1;
            }
            else if (A[i]!=val){
                min_rotationsA++;
            }
            else if (B[i] != val){
                min_rotationsB++;
            }
        }

        return Math.min(min_rotationsA, min_rotationsB);
    }
}