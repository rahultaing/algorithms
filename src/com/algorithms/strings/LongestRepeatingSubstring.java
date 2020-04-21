// https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
// https://leetcode.com/problems/longest-repeating-substring/solution/
// dp solution is much better than this solution


import java.util.HashSet;

public class Solution{

    public int compute(String s){
        int n = s.length();

        int L;
        int l = 1;
        int r = n;

        while (l<=r){

            L = l + (r-l)/2;

            // plus its also not clear why dont we just return L here.
            // as we have already found the length of max string. 
            if (this.search(L, n, s) != -1){
                l = L+1;
            }
            else{
                r = L-1;
            }
        }

        // its not clear why we are returning l-1 
        return l-1;
    }

    private int search(int L, int n, String s){

        HashSet<String> set = new HashSet<>();

        for (int start=0; start<=n-L+1; start++){

            String subString = s.substring(start, start+L);

            if (set.contains(subString)){
                return start;
            }

            set.add(subString);
        }

        return -1;
    }
}


public class Solution2{

    /* example: banana
    str[2] == str[4] == n
    dp[2][4] = dp[1][3] + 1 = 1 + 1 = 2
    dp[1][3] = 1 because there is a string of length 1 that's repeated i.e. `a`
     */
    public int longestRepeatingSubstring(String s){

        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int res = 0;

        for (int i=1; i<=n; i++){
            for (int j=i+1; j<=n; j++){

                if (s.charAt(i-1) == s.charAt(j-1)){

                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}