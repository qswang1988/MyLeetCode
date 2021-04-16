package search.seventyNine;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char [][] board2 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

        System.out.println(Arrays.deepToString(board));

        String word = "ABCB";
        String word2 = "ABCESEEEFS";
        boolean r = new Solution().exist(board2,word2);
        System.out.println(r);
    }

    public boolean exist(char[][] board, String word) {


        // if any char of word doesn't exist in the matrix, then we fail the function directly
        // this can save a lot of time consumption for this test
        String board_str = Arrays.deepToString(board);
        for(char s:word.toCharArray()){
            if(board_str.indexOf(s)==-1)
                return false;
        }

        char [] word_char = word.toCharArray();
        for(int row = 0;row<board.length;row++){
            for(int col = 0;col<board[0].length;col++){
                int [][] map = new int [board.length][board[0].length];
                if(board[row][col] == word_char[0]) {
                    if (search(board, word_char, map, 0, row, col))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, char [] word, int[][] map,int pos, int row, int col){
        //System.out.println("pos: "+pos+" row: "+row+" col: "+col+" char: "+board[row][col]);

        if(pos==word.length-1)
            return true;
        map[row][col] = 1;

        char target = word [pos+1];
        char top = (row-1<0)?0:board[row-1][col];
        char left = (col-1<0)?0:board[row][col-1];
        char right = (col+1>=board[0].length)?0:board[row][col+1];
        char down = (row+1>=board.length)?0:board [row+1][col];
        boolean top_r = (top==target&&map[row-1][col]==0)?search(board,word,map,pos+1,row-1,col):false;
        boolean left_r = (left==target&&map[row][col-1]==0)?search(board,word,map,pos+1,row,col-1):false;
        boolean right_r = (right==target&&map[row][col+1]==0)?search(board,word,map,pos+1,row,col+1):false;
        boolean down_r = (down==target&&map[row+1][col]==0)?search(board,word,map,pos+1,row+1,col):false;

        if(top_r||left_r||right_r||down_r)
            return true;

        // revert the map, it's very important
        map[row][col] = 0;
        return false;

    }
}
