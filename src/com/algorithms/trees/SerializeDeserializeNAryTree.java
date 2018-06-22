package com.algorithms.trees;

public class SerializeDeserializeNAryTree {

    private StringBuilder sb = new StringBuilder();
    public String serialize(NAryTreeNode node){

        if (node == null){
            return this.sb.toString();
        }

        this.recurse(node);
        return this.sb.toString();
    }

    private void recurse(NAryTreeNode node){
        if (node == null){
            return;
        }

        this.sb.append(node.val);

        for (NAryTreeNode nAryTreeNode: node.children){
            this.recurse(nAryTreeNode);
        }

        this.sb.append("#");
    }

    private Integer curIndex = 0;
    public NAryTreeNode deserialize(String s){

        if (curIndex >= s.length()){
            return null;
        }

        if (s.charAt(curIndex) == '#'){
            return null;
        }

        NAryTreeNode node = new NAryTreeNode((int) s.charAt(curIndex));

        while(curIndex < s.length()){
            curIndex++;
            NAryTreeNode child = deserialize(s);
            if (child == null){
                break;
            }

            node.children.add(child);
        }

        return node;
    }
}
