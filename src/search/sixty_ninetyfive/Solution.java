package search.sixty_ninetyfive;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int [][] nums = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int r = new Solution().maxAreaOfIsland(nums);
        System.out.println(r);

        //int r = new Solution().check_around(nums,2,1);
        //System.out.println(r);
    }

    public int maxAreaOfIsland(int[][] grid) {
        /*int [][] nums = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++)
            nums [i] = Arrays.copyOf(grid [i],grid[i].length);*/

        int largest = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]==0)
                    continue;
                /*int r = check_around(grid,i,j);
                if(r>largest)
                    largest = r;*/
                largest = Math.max(largest,check_around(grid,i,j));
                // don't have to check all cell
                if(largest>0)
                    j+=2;
            }
        }
        return largest;
    }

    public int check_around(int [][] nums,int row,int col){
        if(row>=nums.length||col>=nums[0].length)
            return 0;
        if(row<0||col<0)
            return 0;
        if(nums [row][col]!=1)
            return 0;
        nums [row][col] = 0;
        return 1+check_around(nums,row,col+1)+check_around(nums,row+1,col)+check_around(nums,row,col-1)+check_around(nums,row-1,col);
    }

}
