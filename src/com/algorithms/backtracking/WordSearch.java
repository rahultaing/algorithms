package com.algorithms.backtracking;

/*

https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*/

/*runtime complexity analysis:
* I think the time complexity is (mn*4^k) where k is the length of the string;
* mn for for loop and for the dfs method its 4^k. Since the dfs method goes only as
* deep as the word length we have T(k)=4(T(k-1))=4*4T(k-2)=....=.. which will be 4^k.
* */

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int n = board.length;

        if (n == 0){
            return true;
        }

        int m = board[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (this.visit(board, i, j, n, m, 0, word)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean visit(char[][] board, int i, int j, int n, int m, int index, String word){

        if (index >= word.length()){
            return true;
        }

        if (i<0 || j<0 || i>=n || j>=m || board[i][j] == '#'){
            return false;
        }

        boolean result = false;
        Character c = board[i][j];
        if (c == word.charAt(index)){

            board[i][j] = '#';
            if (this.visit(board, i-1, j, n, m, index+1, word)
                    || this.visit(board, i+1, j, n, m, index+1, word)
                    || this.visit(board, i, j-1, n, m, index+1, word)
                    || this.visit(board, i, j+1, n, m, index+1, word)){

                result = true;
            }

            board[i][j] = c;
        }

        return result;
    }
}
