// https://leetcode.com/submissions/detail/118011428/
/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal2{

    private List<List<Integer>> outlist = new ArrayList<>();
    private Stack<List<Integer>> stack = new Stack<>();
    private Queue<TreeNode> q = new LinkedList<>();
    
    public List<List<Integer>> compute(TreeNode node){

        if (node == null){
            return new ArrayList<>();
        }

        q.add(node);

        while (q.size() > 0){
            int count = q.size();

            List<Integer> list = new ArrayList<>();
            for (int i=0; i<count; i++){
                
                TreeNode x = q.remove();
                list.add(x.val);

                if (x.left != null){
                    q.add(x.left);
                }

                if (x.right != null){
                    q.add(x.right);
                }
            }

            this.stack.push(list);
        }

        while (!this.stack.isEmpty()){
            this.outlist.add(this.stack.pop());
        }

        return this.outlist;
    }
}