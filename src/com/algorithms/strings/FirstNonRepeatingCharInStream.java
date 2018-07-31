package com.algorithms.strings;

import java.util.LinkedList;
import java.util.Queue;

/*
* First non repeating character in a stream
*
* https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
*
*Given a stream of characters and we have to find first non repeating character
 *  each time a character is inserted to the stream.

Examples:

Input  : a a b c
Output : a -1 b b

Input  : a a c
Output : a -1 c

*
* */
public class FirstNonRepeatingCharInStream {

    public void findFirstNonRepeatingChar(String s){

        int[] count = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for(char c : s.toLowerCase().toCharArray()) {
            queue.add(c);
            count[c - 'a']++;

            while (!queue.isEmpty()) {
                if (count[queue.peek() - 'a'] == 1) {
                    System.out.print(queue.peek() + " ");
                    break;
                }

                queue.poll();
            }

            if (queue.isEmpty()){
                System.out.print("-1 ");
            }
        }
    }
}
