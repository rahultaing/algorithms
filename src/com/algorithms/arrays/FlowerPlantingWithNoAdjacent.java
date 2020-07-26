package com.algorithms.arrays;

/* 
https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/290858/JavaC%2B%2BPython-Greedily-Paint
*/
public class FlowerPlantingWithNoAdjacent {
    

    public int[] gardenNoAdj(int N, int[][] paths) {
     
        int res = new int[N];

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for (int i=0; i<N; i++){
            graph.put(i, new HashSet<>());
        }

        for (int i=0; i<paths.length; i++){
            graph.get(paths[i][0]-1).add(paths[i][1]-1);
            graph.get(paths[i][1]-1).add(paths[i][0]-1);
        }

        for (int i=0; i<N; i++){

            int[] colors = new int[5];

            for (int nei: graph.get(i)){

                // mark as used
                colors[res[nei]] = 1;
            }

            for (int j=4; j>0; j--){
                if (colors[j] == 0){
                    // found an unused color, set it and move onto next index 
                    res[i] = j;
                    break;
                }
            }
        }

        return res;
    }
}