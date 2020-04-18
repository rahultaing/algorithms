// https://leetcode.com/problems/friend-circles/solution/

package com.algorithms.graphs;

import java.util.Queue;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[M.length];

        for (int i=0; i<M.length; i++){

            if (visited[i]== 0){
                q.add(i);

                while(!q.isEmpty()){
                    int node = q.poll();

                    for (int j=0; j<M.length; j++){
                        if (visited[j]==0 && M[node][j]==1){
                            q.add(j);
                        }
                    }
                }

                // within if block
                count++;
            }

            
        }

        return count;
    }
}