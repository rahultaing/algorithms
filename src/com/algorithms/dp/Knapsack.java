public class Solution{

    public int knapsack(int[] w, int[] v, int maxWeight){

        int[][] dp = new int[v.length + 1][maxWeight + 1];

        for (int i=0; i<=v.length; i++){
            for (int j=0; j<=maxWeight; j++){

                if (i==0 || j==0){
                    dp[i][j] = 0;
                    continue;
                }

                if (j>=w[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i-1][j-w[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[v.length][maxWeight];
    }
}