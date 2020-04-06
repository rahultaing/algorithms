// https://leetcode.com/problems/bus-routes/solution/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.awt.*;
public class Solution{

    public int minBuses(int[][] routes, int source, int dest){

        int n = routes.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i =0; i<n; i++){
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (this.intersect(routes[i], routes[j])){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        HashSet<Integer> target = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int i=0; i<n; i++){
            if (Arrays.binarySearch(routes[i], source) != -1){
                seen.add(i);
                q.add(new Point(i, 0));
            }

            if (Arrays.binarySearch(routes[i], dest) != -1){
                target.add(i);
            }
        }


        while (!q.isEmpty()){
            Point p = q.poll();

            int node = p.x;
            int distance = p.y;

            if (target.contains(node)){
                return distance + 1;
            }

            for (Integer adjNode: graph.get(node)){
                seen.add(adjNode);
                q.add(new Point(adjNode, distance+1));
            }
        }

        return -1;
    }

    private boolean intersect(int[] x, int[] y){

        int n = x.length;
        int m = y.length;

        int i = 0;
        int j = 0;

        while (i<n && j<m){
            if (x[i] == y[j]){
                return true;
            }

            if (x[i] < y[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return false;
    }
}