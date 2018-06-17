package com.algorithms.misc;

/*
* Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
*/
public class BullsCows {

    public String hits(String actual, String guess){

        Integer n = actual.length();
        Integer[] count = new Integer[10];

        Integer i=0;
        Integer bulls = 0;
        Integer cows = 0;

        while (i<n){

            if (actual.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else{
                /*validate if this converts the character to correct integer or
                * instead use - '0' to get the correct index.*/
                Integer v1 = (int) actual.charAt(i);
                Integer v2 = (int) guess.charAt(i);

                if (count[v1]<0) cows++;
                if (count[v2]>0) cows++;

                count[v1]++;
                count[v2]--;
            }
        }

        return bulls.toString() + "A" + cows.toString() + "B";
    }
}
