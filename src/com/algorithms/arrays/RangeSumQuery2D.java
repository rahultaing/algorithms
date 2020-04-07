// https://leetcode.com/problems/range-sum-query-2d-immutable/
// https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75350/Clean-C%2B%2B-Solution-and-Explaination-O(mn)-space-with-O(1)-time

public class NumMatrix {

    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // dp[i][j] represents sum of matrix area matrix[0][0] to matrix[i][j]
        dp = new int[n+1][m+1];
        
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){

                dp[i][j] = dp[i][j-1] + dp[i-1][j] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}