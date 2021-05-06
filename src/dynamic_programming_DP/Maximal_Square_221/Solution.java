package dynamic_programming_DP.Maximal_Square_221;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char [][] matrix1 = {{'1'}};
        char [][] matrix2 = {{'0'}};
        char [][] matrix3 = {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        char [][] matrix4 = {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        int r = new Solution().maximalSquare(matrix3);
        System.out.println(r);
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix [0].length;
        int max_wide = Math.min(m,n);

        int square = 0;
        // width of square, from 1 to ..
        for(int w = 1;w<=max_wide;w++){
            boolean flag = true;
            for(int i = 0;i<m&&flag;i++ ){
                for(int j = 0;j<n;j++){
                    if(matrix[i][j]=='1'){
                        if(check_square(matrix,i,j,w)){
                            //square = Math.max(square,w*w);
                            square = w*w;
                            flag = false;
                            break;
                        }
                    }
                }
            }
            // this is the fucking key
            // if going with current width failed, there is no need to continue searching.
            if(flag)
                break;
        }
        return square;
    }

    public boolean check_square(char [][] matrix, int row, int col, int width){
        if(row+width>matrix.length || col+width>matrix[0].length) {
            matrix [row][col] = '0';
            return false;
        }


        for(int i =row;i<(row+width);i++){
            for(int j=col;j<(col+width);j++){
                if (matrix[i][j]=='0'){
                    matrix [row][col] = '0';
                    return false;
                }
            }
        }
        return true;
    }

}
