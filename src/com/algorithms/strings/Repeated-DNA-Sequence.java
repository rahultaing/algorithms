// https://leetcode.com/problems/repeated-dna-sequences/solution/

import java.util.HashSet;

public class Solution{

    HashSet<String> seen = new HashSet<>();
    HashSet<String> repeated = new HashSet<>();

    int L = 10;
    public List<String> repeatedDnaSequence(String s){

        for (int i=0; i<s.length()-L+1; i++){
            if (seen.contains(s.substring(i, i+L-1))){
                repeated.add(s.substring(i, i+L-1));
            }
            else{
                seen.add(s.substring(i, i+L-1));
            }
        }

        return new ArrayList<>(repeated);
    }
}