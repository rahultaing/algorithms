package com.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Paths {

    private int[] edgeTo;
    private boolean[] visited;
    private UndirectedGraph graph;
    private int source;

    /*Depth first traversal from the source vertex.*/
    public Paths(UndirectedGraph graph, int source){

        this.source = source;
        this.graph = graph;
        this.visited = new boolean[this.graph.vertices];
        this.edgeTo = new int[this.graph.vertices];

        this.visit(source);
    }

    public boolean hasPathTo(int node){
        return this.visited[node];
    }

    public List<Integer> pathTo(int node){

        if (!this.hasPathTo(node)){

            return null;
        }

        Stack<Integer> stack = new Stack<>();

        for (int u=node; u!=source; u=edgeTo[u]){
            stack.push(u);
        }

        stack.push(source);

        return new ArrayList<>(stack);
    }

    private void visit(int node){
        if (!this.visited[node]){
            this.visited[node] = true;

            for (int neighbor : this.graph.adjList[node]) {

                this.edgeTo[neighbor] = node;
                this.visit(neighbor);
            }
        }
    }
}
