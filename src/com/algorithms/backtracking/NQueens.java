package com.algorithms.backtracking;

/*TODO: write test and validate.*/
public class NQueens {

    private int numberOfQueens;
    private int[] board;

    public void placeNQueens(int n){

        this.numberOfQueens = n;
        this.board = new int[n];

        this.place(0);
    }

    private void place(int k){

        if (k == this.numberOfQueens){

            // print board.
            return;
        }

        for (int i=0; i<this.numberOfQueens; i++){
            if (this.canPlace(k, i)){
                board[k] = i;
                this.place(k+1);
            }
        }

    }

    private boolean canPlace(int queen, int col){

        for (int i=0;i<queen;i++){
            if (this.board[i] == col || Math.abs(i-queen) == Math.abs(col-this.board[i])){
                return false;
            }
        }

        return true;
    }
}
