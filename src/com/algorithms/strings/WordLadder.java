package com.algorithms.strings;

/*
https://leetcode.com/problems/word-ladder/description/

Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

import java.util.HashSet;
import java.util.List;

/*TODO: determine time complexity.*/
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        int distance  = 1;

        HashSet<String> reached = new HashSet<>();
        HashSet<String> toAdd = new HashSet<>();

        reached.add(beginWord);
        set.add(endWord);

        while (!reached.contains(endWord)){

            for (String each: reached){

                for (int i = 0; i < each.length(); i++){

                    char[] chArray = each.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++){
                        chArray[i] = k;
                        String transformedWord = new String(chArray);
                        if (set.contains(transformedWord)){
                            toAdd.add(transformedWord);
                            set.remove(transformedWord);
                        }
                    }
                }
            }

            distance++;

            if (toAdd.size() == 0){
                return 0;
            }

            reached = toAdd;
            toAdd.clear();
        }

        return distance;
    }
}
