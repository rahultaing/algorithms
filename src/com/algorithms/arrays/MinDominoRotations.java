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