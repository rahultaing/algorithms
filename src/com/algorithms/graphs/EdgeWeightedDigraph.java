package com.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**/
public class EdgeWeightedDigraph {

    private int v;
    private List<DirectedEdge>[] adjList;

    public EdgeWeightedDigraph(int v){

        this.v = v;
        this.adjList = new List[this.v];

        for (int i = 0; i < this.v; i++){
            this.adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge directedEdge){

        int from = directedEdge.from();
        this.adjList[from].add(directedEdge);
    }

    public List<DirectedEdge> getEdges(int vertex){
        return this.adjList[vertex];
    }

    public int getVertices(){
        return this.v;
    }
}
