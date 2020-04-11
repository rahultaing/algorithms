// https://leetcode.com/submissions/detail/118029396/

import java.util.LinkedList;

import sun.misc.Queue;

public class RightSideView{

    private List<Integer> list;

    public List<Integer> compute(TreeNode node){

        this.list = new ArrayList<>();

        if (node == null){
            return this.list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()){

            int count = queue.count();

            for (int i=0; i<count; i++){

                TreeNode item = queue.dequeue();

                if (i==count-1){
                    this.list.add(item);
                }

                if (item.left != null){
                    queue.add(item.left);
                }

                if (item.right != null){
                    queue.add(item.right);
                }
            }

        }

        return this.list;
    }
}