package com.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {

    public List<Integer>[] adjList;
    public int vertices;

    public UndirectedGraph(int n){
        this.vertices = n;
        this.adjList = new ArrayList[this.vertices];

        for (int i=0; i<n; i++){
            this.adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int i, int j){
        this.adjList[i].add(j);
        this.adjList[j].add(i);
    }
}
