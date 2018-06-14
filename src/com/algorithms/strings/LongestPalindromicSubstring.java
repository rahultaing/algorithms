package com.algorithms.strings;

public class LongestPalindromicSubstring {

    public String lps(String s){

        Integer start = 0;
        Integer end = 0;
        for (Integer i=0; i<s.length(); i++){

            Integer len1 = this.extendFromMiddle(s, i, i);
            Integer len2 = this.extendFromMiddle(s, i, i+1);
            Integer len = Math.max(len1, len2);

            if (len > end-start){

                /*TODO: unclear why this is (len-1)/2 instead of len/2*/
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private Integer extendFromMiddle(String s, Integer l, Integer r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r-l-1;
    }
}
