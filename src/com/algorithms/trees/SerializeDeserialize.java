package com.algorithms.trees;

public class SerializeDeserialize {

    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode node){

        if (node == null){
            return this.sb.toString();
        }

        this.serializeRecurse(node);
        return this.sb.toString();
    }

    private void serializeRecurse(TreeNode node){
        if (node == null){
            this.sb.append("#").append(" ");
            return;
        }

        this.sb.append(node.val).append(" ");
        this.serializeRecurse(node.left);
        this.serializeRecurse(node.right);
    }

    private Integer curIndex = 0;
    public TreeNode deserialize(String s){

        String[] sa = s.split(" ");
        return this.deserializeRecurse(sa);
    }

    private TreeNode deserializeRecurse(String[] sa){

        if (curIndex >= sa.length){
            return null;
        }

        if (sa[curIndex] == "#"){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(sa[curIndex]));
        curIndex++;
        node.left = this.deserializeRecurse(sa);
        node.right = this.deserializeRecurse(sa);
        return node;
    }
}
