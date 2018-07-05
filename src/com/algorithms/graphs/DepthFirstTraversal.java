package com.algorithms.graphs;

/*
https://www.geeksforgeeks.org/iterative-depth-first-traversal/

*/

import java.util.List;

public class DepthFirstTraversal {

    private boolean[] visited;
    public void traverse(UndirectedGraph graph){
        this.visited = new boolean[graph.vertices];

        for (int i = 0; i < graph.vertices; i++){

            if (!this.visited[i]){
                this.visit(graph, i);
            }
        }
    }

    private void visit(UndirectedGraph graph, int vertex){

        System.out.print(vertex);
        this.visited[vertex] = true;

        List<Integer> neighbors = graph.adjList[vertex];

        for(Integer neighbor : neighbors){
            if (!this.visited[neighbor]){
                this.visit(graph, neighbor);
            }
        }
    }

    /*TODO: the iterative version uses a stack. You can code that here next.*/
}
