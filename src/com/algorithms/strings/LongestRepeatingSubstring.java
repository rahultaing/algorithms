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