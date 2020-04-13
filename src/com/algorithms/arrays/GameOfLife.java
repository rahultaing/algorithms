// https://leetcode.com/problems/game-of-life/solution/
public class Solution{

    public int[][] compute(int[][] board){

        int[] neighbor = new int[]{0,1,-1};
        int rows = board.length;
        int cols = board[0].length;

        for (int row=0; row<rows; row++){
            for (int col=0; col<cols; col++){

                int liveCells = 0;

                for (int r=0; r<3; r++){
                    for (int c=0; c<3; c++){
                        int nrow = row + neighbor[r];
                        int ncol = col + neighbor[c];

                        if (!(neighbor[r]==0 && neighbor[c]==0)){

                            if (nrow >= 0 && nrow<rows &&
                                ncol>=0 && ncol<cols && 
                                Math.abs(board[nrow][ncol])==1){
                                
                                    liveCells++;
                            }
                        }
                    }
                }

                if (liveCells==3){
                    if (board[row][col] == 0){
                        board[row][col] = 2;
                    }
                }

                if (liveCells>3 || liveCells<2){
                    if(board[row][col] == 1){
                        board[row][col] = -1;
                    }
                }
            }
        }

        for (int row=0; row<rows; row++){
            for (int col=0; col<cols; col++){
                if (board[row][col]>0){
                    board[row][col] = 1;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return board;
    }
}