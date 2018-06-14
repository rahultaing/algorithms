package com.algorithms.strings;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        Integer n = strs.length;

        if (n == 0){
            return "";
        }

        String pre = strs[0];

        for (Integer i = 1; i < n; i++){

            while (strs[i].indexOf(pre) != 0 && pre.length() > 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }
}
