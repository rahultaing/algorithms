// https://leetcode.com/problems/bomb-enemy/discuss/83387/Short-O(mn)-time-O(n)-space-solution

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        int row_count;
        int[] col_count = new int[cols];

        for (int r=0; r<rows; r++){

            for (int c=0; c<cols; c++){

                if (c==0 || grid[r][c-1] == 'W'){
                    row_count = 0;

                    for (int i=c; i<cols && grid[r][i]!='W'; i++){
                        if (grid[r][i] == 'E'){
                            row_count++;
                        }
                    }
                }

                if (r==0 || grid[r-1][c] == 'W'){
                    col_count[c] = 0;

                    for (int i=r; i<rows&&grid[i][c]!='W'; i++){
                        if (grid[i][c] == 'E'){
                            col_count[c]++;
                        }
                    }
                }

                if (grid[r][c]=='0'){
                    result = Math.max(result, row_count+col_count[c]);
                }
            }
        }

        return result;
    }
}