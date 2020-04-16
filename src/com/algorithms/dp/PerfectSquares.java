// https://leetcode.com/submissions/detail/125537033/
import java.util.Arrays;

public class Solution{

    public int findMinPerfectSquares(int n){

        if (n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=1; i<=n; i++){
            for (int j=1; j*j<=i; j++){

                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }

        return dp[n];
    }
}