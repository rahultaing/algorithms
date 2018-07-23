package com.algorithms.common;

import java.util.List;

public class Digraph {

    private int v;
    private List<Integer>[] adj;

    public Digraph(int v){
        this.v = v;
        this.adj = new List[this.v];
    }
    public int getVertexCount(){
        return this.v;
    }

    public List<Integer> getNeighbors(int vertex){
        return this.adj[vertex];
    }
}
