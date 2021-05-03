package dynamic_programming_DP.sixty_four;

public class Solution {

    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int r = new Solution().minPathSum(grid);
        System.out.println(r);
    }

    // find the min_sum of each cell
    public int minPathSum(int[][] grid) {
        int [][] map = new int[grid.length][grid[0].length];
        int sum = 0;
        for(int row = 0;row<grid.length;row++){
            for(int col = 0;col<grid[0].length;col++)
                sum = min_sum(grid,map,row,col);
        }

        return sum;
    }

    public int min_sum(int [][] grid,int [][] map,int row,int col){
        if(row==0&&col==0) {
            map[row][col] =  grid[row][col];
            return grid[row][col];
        }

        int left = (col==0)?Integer.MAX_VALUE:map[row][col-1];
        int up = (row==0)?Integer.MAX_VALUE:map[row-1][col];
        int sum = Math.min(left,up) + grid[row][col];
        map[row][col] = sum;
        //System.out.println("min_sum: "+sum);
        return sum;
    }
}
