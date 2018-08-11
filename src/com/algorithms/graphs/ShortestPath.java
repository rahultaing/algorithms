package com.algorithms.graphs;

import java.util.PriorityQueue;

/*Dijkstra's shortest path*/
public class ShortestPath {

    private int[] edgeTo;
    private double[] distTo;
    private PriorityQueue<Integer> minPq;
    private EdgeWeightedDigraph digraph;

    public ShortestPath(EdgeWeightedDigraph digraph, int source){

        this.digraph = digraph;
        this.distTo = new double[digraph.getVertices()];
        this.edgeTo = new int[digraph.getVertices()];

        for (int i=0; i<digraph.getVertices(); i++){
            this.distTo[i] = Double.MAX_VALUE;
        }

        this.distTo[source] = 0.0;

        // TODO: implement indexed minPQ;
        this.minPq = new PriorityQueue<>();

        this.minPq.add(source);

        while(!this.minPq.isEmpty()){

            int vertex = this.minPq.poll();
            this.relax(vertex);
        }
    }

    private void relax(int vertex){
        for (DirectedEdge edge: this.digraph.getEdges(vertex)){

            int w = edge.to();

            if (this.distTo[w] > this.distTo[vertex] + edge.getWeight()){
                this.distTo[w] = this.distTo[vertex] + edge.getWeight();
                this.edgeTo[w] = vertex;

                //TODO: if already exists then update, otherwise add. Can't do with existing PQ.
                this.minPq.add(w);
            }
        }
    }
}
