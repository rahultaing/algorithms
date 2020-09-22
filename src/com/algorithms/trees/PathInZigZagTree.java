/*https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/324011/Python-O(logn)-time-and-space-with-readable-code-and-step-by-step-explanation */

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list  = new LinkedList<>();
         int node_count = 1;
         int level = 1;
         while(label >= node_count * 2){
             node_count *= 2;
             level++;
         }
        
         while(label !=0) {
             list.add(label);
             int levelmax = ((int)Math.pow(2, level)) - 1;
             int levelmin = (int)Math.pow(2, level-1);
             label = (int)((levelmax + levelmin - label)/2);
             level--;
             
         }
         Collections.reverse(list);
         return list;
    }
}