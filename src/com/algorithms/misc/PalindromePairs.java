package com.algorithms.misc;

/*

https://leetcode.com/problems/palindrome-pairs/description/

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

/*TODO: determine time/space complexity.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {

        int n = words.length;

        if (n == 0){
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++){
            map.put(words[i], i);
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<=words[i].length(); j++){

                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);

                this.addPair(s1, s2, map,i, false);

                if (!s2.isEmpty()){
                    this.addPair(s2, s1, map,i, true);
                }
            }
        }

        return this.result;
    }

    private void addPair(String s1, String s2, HashMap<String, Integer> map, int index, boolean isRev){

        if (this.isPalindrome(s1)){

            String s2Rev = new StringBuilder(s2).reverse().toString();

            if (map.containsKey(s2Rev) && map.get(s2Rev) != index){

                List<Integer> list = new ArrayList<>();
                if (isRev){
                    list.add(index);
                    list.add(map.get(s2Rev));
                }
                else{
                    list.add(map.get(s2Rev));
                    list.add(index);
                }

                this.result.add(list);
            }
        }
    }

    private boolean isPalindrome(String s){

        int l=0;
        int r = s.length()-1;

        while(l<=r){

            if (s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
