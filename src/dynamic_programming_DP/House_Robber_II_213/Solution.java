package dynamic_programming_DP.House_Robber_II_213;

/*
*  https://leetcode.com/problems/house-robber-ii/
*  Medium
*
*
*   [5,7,9,5,5,6]
*   2 conditions,then don't consider head and tail problem
*
*   now the problem looks like problem 198, https://leetcode.com/problems/house-robber/
*
*   condition 1: index 0-4 [5,7,9,5,5]
*   condition 2: index 1-5 [7,9,5,5,6]
*
*   result = Max(c1,c2)
*
*
* */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int r = new Solution().rob(nums);
        System.out.println(r);
    }

    public int rob(int[] nums) {

        if(nums.length<2)
            return nums[0];

        int head_taken = get_max(nums,0,nums.length-2);
        int tail_taken = get_max(nums,1,nums.length-1);
        return Math.max(head_taken,tail_taken);
    }

    public static int get_max(int [] nums,int start,int end){
        int pre = 0;
        int cur = nums [start];
        for(int i = start+1;i<=end;i++){
            int t = nums[i];
            int temp = cur;
            cur = pre + t;
            pre = Math.max(temp,pre);
        }
        return Math.max(pre,cur);
    }


}
