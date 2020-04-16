package com.algorithms.trees;

/*

https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/

Three solutions:
1. recursive.
2. iterative.
3. level order traversal.

*/
public class MirrorTrees {

    public boolean recursiveAreMirror(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null){
            return true;
        }

        if (node1 == null || node2 == null){
            return false;
        }

        return node1.val == node2.val &&
                this.recursiveAreMirror(node1.left, node2.right) &&
                this.recursiveAreMirror(node1.right, node2.left);
    }

    public boolean iterativeAreMirror(TreeNode node1, TreeNode node2){

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        while (true){
            while(node1 != null && node2!=null){
                if (node1.val!=node2.val){
                    return false;
                }

                st1.push(node1);
                st2.push(node2);
                node1 = node1.left;
                node2 = node2.right;
            }

            if ((node1==null && node2!=null) || (node1!=null && node2==null)){
                return false;
            }

            if (!st1.isEmpty() && !st2.isEmpty()){
                node1 = st1.pop();
                node2 = st2.pop();
                node1 = node1.right;
                node2 = node2.left;
            }
            else{
                break;
            }
        }
        return true;
    }

    public boolean levelOrderAreMirror(TreeNode p, TreeNode q){
        //https://www.geeksforgeeks.org/check-if-two-trees-are-mirror-of-each-other-using-level-order-traversal/
     
        Queue<TreeNode> queue = new LinkedList<>();

        if (p==null && q==null){
            return true;
        }

        if (p==null || q==null){
            return false;
        }

        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()){

            p = queue.poll();
            q = queue.poll();

            if (p.val != q.val){
                return false;
            }

            if (p.left != null && q.right!=null){
                queue.add(p.left);
                queue.add(q.right);
            }
            else if ((p.left==null && q.right!=null) || (p.left!=null && q.right == null)){
                return false;
            }

            if (p.right != null && q.left!=null){
                queue.add(p.right);
                queue.add(q.left);
            }
            else if ((p.right==null || q.left!=null) || (p.right!=null && q.left==null)){
                return false;
            }
        }

        return true;
    }
}
