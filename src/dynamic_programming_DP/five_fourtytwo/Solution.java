package dynamic_programming_DP.five_fourtytwo;

import java.util.Arrays;

public class Solution {

    /*

    [[0,0,1,0,1,1,1,0,1,1],
     [1,1,1,1,0,1,1,1,1,1],
     [1,1,1,1,1,0,0,0,1,1],
     [1,0,1,0,1,1,1,0,1,1],
     [0,0,1,1,1,0,1,1,1,1],
     [1,0,1,1,1,1,1,1,1,1],
     [1,1,1,1,0,1,0,1,0,1],
     [0,1,0,0,0,1,0,0,1,1],
     [1,1,1,0,1,1,0,1,0,1],
     [1,0,1,1,1,0,1,1,1,0]]

    */


    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int [][] mat2 = {{1,1,0,0,1},{1,0,0,1,0},{1,1,1,0,0}};
        int [][] mat3 = {{1},{1},{1},{1},{1},{0},{1},{0},{0},{1},{1},{0},{1},{1},{1},{1},{1},{0}};
        int [][] r = new Solution().updateMatrix(mat3);
        System.out.println(Arrays.deepToString(r));
    }


    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        System.out.println("m:"+m+",n:"+n);
        int [][] map = new int [m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==1)
                    map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                check_dist(map,i,j);
            }
        }

        if(map[0][0]!=0) {
            if (m > 1 && n > 1)
                map[0][0] = Math.min(map[0][1] + 1, map[1][0] + 1);
            else if (m > 1)
                map[0][0] = map[1][0] + 1;
            else
                map[0][0] = map[0][1] + 1;
        }
        return map;
    }

    public void check_dist(int [][] map, int row, int col){
        if(map[row][col]==0){
            correct(map,row,col);
        }else{
            int up = (row == 0) ? Integer.MAX_VALUE : map[row - 1][col];
            int left = (col == 0) ? Integer.MAX_VALUE : map[row][col - 1];
            int min = Math.min(up, left);
            if(min==Integer.MAX_VALUE)
                return;
            map[row][col] = min+1;
        }
    }

    public void correct(int [][] map, int row, int col){
        int m = map.length-1;
        int n = map[0].length-1;
        int up = (row == 0) ? Integer.MIN_VALUE : map[row - 1][col];
        int left = (col == 0) ? Integer.MIN_VALUE : map[row][col - 1];
        int right = (col == n)?Integer.MIN_VALUE : map[row][col + 1];
        int down = (row == m) ? Integer.MIN_VALUE : map[row + 1][col];

        int dist = map [row][col];
        if(up>dist+1) {
            map [row - 1][col] = dist+1;
            correct(map, row - 1, col);
        }
        if(left>dist+1) {
            map [row][col-1] = dist+1;
            correct(map, row, col - 1);
        }
        if(dist!=0&&right>dist+1){
            map [row][col+1] = dist+1;
            correct(map, row, col + 1);
        }
        if(dist!=0&&down>dist+1) {
            map [row + 1][col] = dist+1;
            correct(map, row + 1, col);
        }

    }

}
