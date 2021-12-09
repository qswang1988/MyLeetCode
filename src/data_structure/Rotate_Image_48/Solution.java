package data_structure.Rotate_Image_48;

import Math.Minimum_Moves_to_Equal_Array_Elements_II_462.Solution2;

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        for(int i = 0;i<matrix[0].length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        new Solution().rotate(matrix);
        for(int i = 0;i<matrix[0].length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }


    // matrix [row] [col]   ->rotate right 90    matrix [col][n-row-1]
    public void rotate(int[][] matrix) {
        int n = matrix [0].length - 1;

        int depth = n/2;
        //System.out.println("depth: "+depth);

        for(int i = 0;i<=depth;i++){
            for(int j = i;j<n-i;j++){
                //System.out.println("x: "+i+", y: "+j);
                replace(matrix,n,matrix[i][j],j,n-i,i,j);
            }
        }

    }

    // recursive replacing
    public void replace(int[][] matrix,int n,int num,int tX,int tY,int startX,int startY){
        if(tX == startX && tY == startY){
            matrix [tX][tY] = num;
            return;
        }
        int toX = tY;
        int toY = n - tX;
        int temp = matrix [tX][tY];
        matrix [tX][tY] = num;
        replace(matrix,n,temp,toX,toY,startX,startY);
    }


}
