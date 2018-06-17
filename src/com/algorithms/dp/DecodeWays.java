package com.algorithms.dp;

public class DecodeWays {

    public int numDecodings(String s) {

        Integer n = s.length();

        if (n == 0){
            return 0;
        }

        Integer[] dp = new Integer[n+1];

        /*TODO: understand why dp[0] is 1? and why is dp of length n+1 instead of length n*/
        dp[0] = 1;

        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (Integer i=2; i<=n; i++){
            Integer v1 = Integer.valueOf(s.substring(i-1, i));
            Integer v2 = Integer.valueOf(s.substring(i-2, i));

            if (v1 <= 9 && v1 >= 1){
                dp[i] += dp[i-1];
            }

            if (v2 >= 10 && v2 <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
