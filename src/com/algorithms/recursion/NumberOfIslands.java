package com.algorithms.recursion;

/*
* https://leetcode.com/problems/number-of-islands/description/
*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/
public class NumberOfIslands {

    private int count = 0;
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {

        this.rows = grid.length;

        if (this.rows == 0){
            return this.count;
        }

        this.cols = grid[0].length;

        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.cols; j++){
                if (grid[i][j] == '1') {
                    this.count++;
                    this.recurse(grid, i, j);
                }
            }
        }

        return this.count;
    }

    private void recurse(char[][] grid, int i, int j){

        if (i<0 || j<0 || i>=this.rows || j>=this.cols || grid[i][j]==0){
            return;
        }

        grid[i][j] = 0;

        this.recurse(grid, i-1, j);
        this.recurse(grid, i+1, j);
        this.recurse(grid, i, j-1);
        this.recurse(grid, i, j+1);
    }
}
