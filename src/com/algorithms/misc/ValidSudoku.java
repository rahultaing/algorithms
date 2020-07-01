package com.algorithms.misc;

import java.util.HashSet;

public class ValidSudoku {

    private char[][] board;
    public boolean isValidSudoku(char[][] board) {

        this.board = board;

        for (int i=0; i<9; i++){

            if (!this.isValid(i, 0, i, 8)){
                return false;
            }
        }


        for (int i=0; i<9; i++){

            if (!this.isValid(0, i, 8, i)){
                return false;
            }

        }

        for (int i=0; i<3; i++){

            for (int j=0; j<3; j++){

                if (!this.isValid(i*3, j*3, i*3+2, j*3+2)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int x1, int y1, int x2, int y2){

        HashSet<Character> set = new HashSet<>();

        for (int i=x1; i<=x2; i++){
            for (int j=y1; j<=y2; i++){

                if (this.board[i][j]=='.'){
                    continue;
                }

                if (set.contains(this.board[i][j])){
                    return false;
                }

                set.add(this.board[i][j]);
            }
        }
        return true;
    }
}
