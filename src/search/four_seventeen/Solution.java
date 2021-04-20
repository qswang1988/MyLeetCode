package search.four_seventeen;

import java.util.*;

/*
*   1. find out points where water can goes to atlantic ocean, mark them in a matrix A
*   2. find out points .... pacific ocean, mark them .... matrix B
*   3. find out the points shared by 2 matrix, add them into list.
* */
public class Solution {
    public static void main(String[] args) {
        int [][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int [][] heights2 = {{10,10,10},{10,1,10},{10,10,10}};
        int [][] heights3 = {{1,2,3},{8,9,4},{7,6,5}};
        int [][] heights4 = {{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}};
        List<List<Integer>> list = new Solution().pacificAtlantic(heights);
        System.out.println(list.size());
        for(List<Integer> l:list){
            System.out.println(l.get(0)+","+l.get(1));
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int w = heights [0].length;
        int h = heights.length;
        int [][] atlantic_map = new int [h][w];
        int [][] pacific_map = new int [h][w];
        int [] direct = {-1,0,1,0,-1};
        for(int i = 0;i<h;i++) {
            check_around(heights, direct,atlantic_map, w, h, i, 0);
            check_around(heights, direct,pacific_map, w, h, i, w-1);
        }
        for(int i = 0;i<w;i++) {
            check_around(heights, direct,atlantic_map,w, h, 0, i);
            check_around(heights, direct,pacific_map, w, h, h-1, i);
        }

        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                if(pacific_map[i][j]==1&&atlantic_map[i][j]==1)
                    list.add(List.of(i,j));
            }
        }

        return list;
    }

    // 1: Atlantic target
    // 2: Pacific  target
    public void check_around(int[][] heights, int [] direct,int[][] map,int w, int h, int row, int col) {
        //System.out.println("row: "+row+", col: "+col+", last_row:"+last_row+", last_col:"+last_col);
        int target = heights [row][col];
        map [row][col] = 1;
        for(int i = 0;i<4;i++){
            int X = row + direct [i];
            int Y = col + direct [i+1];
            if(X>=0&&X<h&&Y>=0&&Y<w&&map[X][Y]!=1) {
                int next = heights[X][Y];
                if (next >= target)
                    check_around(heights, direct, map, w, h, X, Y);
            }
        }
    }



}
