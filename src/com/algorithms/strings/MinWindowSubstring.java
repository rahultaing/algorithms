// https://leetcode.com/problems/minimum-window-substring/solution/

import java.util.HashMap;

public class Solution{

    public String minWindowSubstring(String s, String t){

          if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i=0; i< t.length(); i++){
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = countMap.size();

        int l=0, r=0;
        int formed = 0;

        // length, l , r
        int[] ans = new int[]{-1,0,0};

        HashMap<Character, Integer> sourceMap = new HashMap<>();
        while (r<s.length()){

            sourceMap.put(s.charAt(r), sourceMap.getOrDefault(s.charAt(r), 0) + 1);

            if (countMap.containsKey(s.charAt(r)) && 
                countMap.get(s.charAt(r)) == sourceMap.get(s.charAt(r))){
                formed++;
            }

            while (l<=r && formed==required){

                if (ans[0] == -1 || ans[0]<r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }

                sourceMap.put(s.charAt(l), sourceMap.get(s.charAt(l))-1);

                if (countMap.get(s.charAt(l)) != sourceMap.get(s.charAt(l))){
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(l,r);
    }
}