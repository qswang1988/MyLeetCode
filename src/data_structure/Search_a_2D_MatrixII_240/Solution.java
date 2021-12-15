package data_structure.Search_a_2D_MatrixII_240;

// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 16;
        boolean r = new Solution().searchMatrix(matrix,target);
        System.out.println(r);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix [0].length;
        int height = matrix.length;

        if(matrix [height-1][width-1]<target)
            return false;

        int i = 0,j = 0;
        for(;i<height&&j<width;i++,j++){
            int curr = matrix[i][j];
            if(curr==target)
                return true;
            else if(curr>target){
                if(checkRowNCol(matrix,i,j,target))
                    return true;
            }
        }

        int m = height - 1;
        int n = width - 1;
        for(;m>=0&&n>=0;m--,n--){

            if(m<i&&n<j)
                break;


            int curr = matrix[m][n];
            if(curr==target)
                return true;
            else if(curr>target){
                if(checkRowNCol(matrix,m,n,target))
                    return true;
            }
        }

        return false;
    }

    boolean checkRowNCol(int [][] matrix,int X,int Y,int target){


        for(int i = X;i>=0;i--){
            if(matrix[i][Y]<target)
                break;
            if(matrix[i][Y]==target)
                return true;
        }



        for(int i = Y;i>=0;i--){
            if(matrix[X][i]<target)
                break;
            if(matrix[X][i]==target)
                return true;
        }


        return false;
    }


}
