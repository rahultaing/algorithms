package com.algorithms.backtracking;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9
*/

/*TODO: determine time/space complexity.*/

/*last practiced date: 7/8/2018*/
public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        this.recurse(board);
    }

    private boolean recurse(char[][] board){

        int n = board.length;

        if (n == 0){
            return true;
        }

        int m = board[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){

                if (board[i][j] == '.') {

                    for (char c = '1'; c<='9'; c++){
                        if (this.isValid(board, i, j, c)){

                            board[i][j] = c;

                            if (this.recurse(board)){
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c){

        for (int row=0; row<9; row++){
            if (board[row][j] == c){
                return false;
            }
        }

        for (int col=0; col<9; col++){
            if (board[i][col] == c){
                return false;
            }
        }

        for (int row=(i/3)*3; row<(i/3)*3 + 3; row++){
            for(int col=(j/3)*3; col<(j/3)*3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }

        return true;
    }
}