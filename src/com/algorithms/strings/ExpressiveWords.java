import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/expressive-words/solution/

/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 
*/
public class Solution{

    public int expressiveWords(String s, String[] words){

        RLE r = new RLE(s);

        int total=0;

        for (int i=0; i<words.length; i++){

            RLE r2 = new RLE(words[i]);

            if (r.key!=r2.key){
                continue;
            }
            
            int j=0;
            for (; j<r.counts.size(); j++){
                int c1 = r.counts.get(j);
                int c2 = r2.counts.get(j);

                if ((c1<3 && c1 != c2) || c2>c1){
                    break;
                }
            }

            if (j==r.counts.size()){
                total++;
            }
        }

        return total;
    }

    // run length encoding
    public class RLE{

        public String key;
        public List<Integer> counts;

        public RLE(String s){

            char[] ca = s.toCharArray();
            int n = s.length();
            counts = new ArrayList<>();
            int prev = -1;

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++){

                if (ca[i]!=ca[i+1] || i==n-1){

                    sb.append(ca[i]);
                    counts.add(i-prev);
                    prev=i;
                }
            }

            key = sb.toString();
        }
    }
}