/*https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/ */

public class Solution{

    private TreeMap<Integer, Integer> map;

    public List<Integer> verticalSum(TreeNode node){

        this.map = new TreeMap<>();

        this.recurse(node, 0);
        return this.map.values();
    }

    private void recurse(TreeNode node, int col){

        if (node == null){
            return;
        }

        this.recurse(node.left, col-1);
        if (this.map.containsKey(col)){
            this.map.put(col, this.map.get(col) + node.val);
        }
        else{
            this.map.put(col, node.val);
        }
        
        this.recurse(node.right, col+1);
    }
}