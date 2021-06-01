package dynamic_programming_DP.PartitionEqualSubsetSum_416;


import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {1,5,11,5};
        int [] nums1 = {1,2,3,5};
        int [] nums2 = {1,2,5};
        int [] nums3 = {1,2,3,4,5,6,7};
        int [] nums4 = {23,13,11,7,6,5,5};
        int [] nums5 = {9,5};
        boolean r = new Solution2().canPartition(nums5);
        System.out.println(r);
    }

    /*

         num = [1,5,11,5], sum = 22
         target = sum/2 = 11

         we change the question to another question
         find if N elements of num that can be added up to target(11)

         0 1 2 3 4 5 6 7 8 9 10 11
       0 y y
       1 y y         y
       2 y y         y
       3 y y         y          y



    *
     */

    public boolean canPartition(int[] nums) {
        if(nums.length<2)
            return false;
        int sum = 0;
        int max = 0;
        // for(int i:nums) is less efficient in the environment of international version leetcode.com
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            max = Math.max(nums[i],max);
        }

        if(sum%2==1)
            return false;
        int target = sum/2;
        if(max>target)
            return false;

        boolean dp [][] = new boolean [nums.length][target+1];
        dp[0][nums[0]] = true;

        for(int i = 1;i<nums.length;i++){
            int t = nums [i];
            if(t==target||dp[i-1][target-t])
                return true;
            for(int j = 1;j<=target;j++){
                if(dp[i-1][j]==true||j==t){
                    dp [i][j] = true;
                    continue;
                }
                if(j>t&&dp[i-1][j-t]==true)
                    dp[i][j] = true;
            }
        }
        return dp [nums.length-1][target];
    }

}

