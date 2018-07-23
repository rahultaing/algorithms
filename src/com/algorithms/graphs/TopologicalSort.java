package com.algorithms.graphs;

import com.algorithms.common.Digraph;
import java.util.Stack;

public class TopologicalSort {

    private Stack<Integer> stack = new Stack<>();
    private boolean[] marked;
    private Digraph digraph;

    public Iterable<Integer> topologicalSort(Digraph digraph){

        this.digraph = digraph;
        this.marked = new boolean[digraph.getVertexCount()];

        for (int v = 0; v< digraph.getVertexCount(); v++){

            if (!this.marked[v]){
                this.dfs(v);
            }
        }

        return this.stack;
    }

    private void dfs(int v){

        this.marked[v] = true;

        for (int neighbor : this.digraph.getNeighbors(v)){

            if (!this.marked[neighbor]){
                this.dfs(neighbor);
            }
        }

        this.stack.push(v);
    }
}
