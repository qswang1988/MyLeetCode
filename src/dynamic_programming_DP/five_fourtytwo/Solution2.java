package dynamic_programming_DP.five_fourtytwo;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int [][] mat2 = {{1,1,0,0,1},{1,0,0,1,0},{1,1,1,0,0}};
        int [][] mat3 = {{1},{1},{1},{1},{1},{0},{1},{0},{0},{1},{1},{0},{1},{1},{1},{1},{1},{0}};
        int [][] r = new Solution2().updateMatrix(mat);
        System.out.println(Arrays.deepToString(r));
    }


    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] map = new int [m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==1)
                    map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j]!=0)
                    check_dist(map,i,j);
            }
        }
        //System.out.println(Arrays.deepToString(map));
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(map[i][j]!=0)
                    check_dist_reverse(map,i,j);
            }
        }


        return map;
    }

    public void check_dist(int [][] map, int row, int col){
        int up = (row == 0) ? Integer.MAX_VALUE : map[row - 1][col];
        int left = (col == 0) ? Integer.MAX_VALUE : map[row][col - 1];
        int min = Math.min(up, left);
        if(min!=Integer.MAX_VALUE)
            map[row][col] = min+1;
    }

    public void check_dist_reverse(int [][] map, int row, int col){
        int dist = map[row][col];
        int down = (row == map.length - 1) ? dist: map[row + 1][col];
        int right = (col == map [0].length - 1) ? dist : map[row][col + 1];
        int min = Math.min(down,right);
        map[row][col] = Math.min(dist,min+1);
    }


}
