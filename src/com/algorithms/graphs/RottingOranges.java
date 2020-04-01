// https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments

import sun.misc.Queue;

public class Solution{

    public int rottingTomatoes(int[][] grid){

        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int current_good = 0;
        int n= grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i =0; i<n; i++){
            for (int j=0; j<m; j++){

                if (grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }

                if (grid[i][j]==1){
                    current_good++;
                }
            }
        }

        int count=0;

        while (!q.isEmpty()){
            int size = q.length();
            count++;

            for (int i=0; i<size; i++){
                int[] point = q.poll();

                for (int[] d: dir){
                    int x = point[0] + d[0];
                    int y = point[1] + d[1];

                    if (x<0||y<0||x>=n||y>=m||grid[x][y]==0||grid[x][y]==2){
                        continue;
                    }

                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                    current_good--;
                    if (current_good==0){
                        return count;
                    }
                }
            }
        }

        return current_good == 0 ? count : -1;
    }
}