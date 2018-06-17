package com.algorithms.dp;

public class InterleavingStrings {

    public Boolean isInterleaving(String s1, String s2, String s3){

        if (s3.length() != s1.length() + s2.length()){
            return false;
        }

        Integer n = s1.length();
        Integer m = s2.length();

        Boolean[][] dp = new Boolean[n+1][m+1];

        for (Integer i=0; i<=n; i++){
            for (Integer j=0; j<=m; j++){

                if (i==0 && j==0){
                    dp[i][j] = true;
                }
                else if (i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
                else if (j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                else{
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])
                            || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
