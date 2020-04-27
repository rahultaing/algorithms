// https://leetcode.com/problems/find-duplicate-subtrees/solution/

public class Solution{

    private List<TreeNode> list = new ArrayList<>(); 
    private HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubTrees(TreeNode node){

        if (node == null){
            return this.list;
        }

        this.recurse(node);
        return this.list;
    }

    private String recurse(TreeNode node){

        if (node == null){
            return "#";
        }

        String s = node.val + "," + this.recurse(node.left) + "," + this.recurse(node.right);

        this.map.put(s, this.map.getordefault(s, 0) + 1);

        int count = this.map.get(s);

        if (count == 2){
            this.list.add(node);
        }

        return s;
    }
}