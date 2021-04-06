package search.five_fourtyseven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int [][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        int [][] nums2 = {{1,0,0},{0,1,0},{0,0,1}};
        int r = new Solution().findCircleNum(nums2);
        System.out.println(r);
    }

    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        for(int i = 0;i<isConnected.length;i++){
            if(isConnected[i][i]==1) {
                num++;
                find_neighbour(isConnected, i);
            }
        }
        return num;
    }

    public void find_neighbour(int[][] nums,int row){
        if(nums[row][row]==0)
            return;
        //nums [row] = new int [nums [row].length];
        nums [row][row] = 0;
        for(int i = 0;i<nums.length;i++){
            if(i==row)
                continue;
            if(nums [i][row] == 1)
                find_neighbour(nums,i);
        }
    }

}
