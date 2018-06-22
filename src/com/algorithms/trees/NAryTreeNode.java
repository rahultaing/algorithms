package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeNode {

    public Integer val;
    public List<NAryTreeNode> children;

    public NAryTreeNode(Integer val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}
