package dynamic_programming_DP.Maximum_Subarray_53;

/*
*
*   https://leetcode.com/problems/maximum-subarray/
*   EASY
*
*   Solution:
*   [8,-19,5,-4,20]
*   i: last = max(last+nums[i],nums[i]);
*
*   0: [8,8] ->8
*   1: [-11,-19]  -> -11
*   2: [-6,5]  -> 5
*   3: [1,-4] -> 1
*   4: [21,20] -> 21
*
*   result = max(8,-11,5,1,21)
*   21 is the subarray of the largest sum
*
* */

public class Solution {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int [] nums2 = {8,-19,5,-4,20};
        int [] nums3 = {1,-3,2,0,-1,0,-2,-3,1,2,-3,2};
        int [] nums4 = {-2,1};
        int [] nums5 = {-2,-1};
        int [] nums6 = {-1,0,-2};
        int [] nums7 = {-1,-2};
        int r = new Solution().maxSubArray(nums7);
        System.out.println(r);
    }

    public int maxSubArray(int[] nums) {
        if(nums.length<2)
            return nums [0];

        int last = nums [0],r = nums[0];
        for(int i = 1;i<nums.length;i++){
            int t = nums [i];
            last = Math.max(t,last+t);
            r = Math.max(last,r);
        }
        return r;
    }


}
