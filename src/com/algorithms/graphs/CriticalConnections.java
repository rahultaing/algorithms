package com.algorithms.graphs;

// https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/No-TarjanDFS-detailed-explanation-O(orEor)-solution-(I-like-this-question)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CriticalConnections {

    public List<List<Integer>> compute(int n, List<List<Integer>> connections){

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<List<Integer>> edges = new HashSet<>();

        for(List<Integer> connection: connections){

            if (connection.get(0) > connection.get(1)){
                int temp = connection.get(0);
                connection.set(0, connection.get(1));
                connection.set(1, temp);
            }

            List<Integer> list;
            if (!graph.containsKey(connection.get(0))){

                list = new ArrayList<>();
            }

            list = graph.get(connection.get(0));
            list.add(connection.get(1));
            
            List<Integer> list2;
            if (!graph.containsKey(connection.get(1))){

                list2 = new ArrayList<>();
            }

            list2 = graph.get(connection.get(1));
            list2.add(connection.get(0));

            edges.add(connection);
        }

        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        this.recurse(graph, edges, rank, 0, 0);

        return new ArrayList<>(edges);
    }

    private int recurse(HashMap<Integer, List<Integer>> graph, HashSet<List<Integer>> edges, int[] rank, int node, int height){

        if (rank[node] > 0){
            return rank[node];
        }

        rank[node] = height;
        
        int min_height = height;
        for (Integer neighbor: graph.get(node)){
            // not sure why we are doing this, but for some reason this check is to avoid going back to the node where we might have come from.
            if(rank[neighbor] == height-1){
                continue;
            }

            int recurse_min = this.recurse(graph, edges, rank, neighbor, height+1);
            min_height = Math.min(min_height, recurse_min);

            // its a cycle
            if (recurse_min <= height){
                edges.remove(Arrays.asList(Math.min(node, neighbor), Math.max(node, neighbor)));
            }
        }

        return min_height;
    }
}