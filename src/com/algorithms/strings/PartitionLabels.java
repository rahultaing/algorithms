package com.algorithms.strings;

/*https://leetcode.com/problems/partition-labels/solution/

*/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();

        int anchor = 0, j = 0;

        int[] last = new int[26];
        for (int i=0; i<s.length(); i++){

            last[s.charAt(i) - 'a'] = i;
        }

        for (int i=0; i<s.length(); i++){

            j = Math.max(j, last[s.charAt(i) - 'a']);

            if (i==j){
                list.add(i-anchor+1);
                anchor = i+1;
            }
        }

        return list;
    }
}