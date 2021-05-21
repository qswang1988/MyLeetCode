package dynamic_programming_DP.Longest_Increasing_Subsequence_300;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        int [] nums1 = {1,2,3,4,5,6,7,8,9,10};
        int [] nums3 = {2,15,3,7,8,6,18};
        int r = new Solution().lengthOfLIS(nums);
        System.out.println(r);
    }

    public int lengthOfLIS(int[] nums) {
        //Map<Integer,Integer> map = new HashMap<>();
        // array is more efficient in this case
        int [] map = new int [nums.length];
        int max_len = 0;
        for(int i = 0;i<nums.length;i++){
            if(i<nums.length-1&&nums [i]>=nums[i+1])
                continue;
            max_len = Math.max(search(i,nums,map),max_len);
        }
        return max_len;
    }

    public int search(int startIndex,int [] nums, int[] map){
        if(map [startIndex]!=0)
            return map [startIndex];
        int current = nums [startIndex];
        int max_l = 1;
        int min_next = Integer.MAX_VALUE;
        for(int i = startIndex+1;i<nums.length;i++){
            if(nums[i]>current && nums [i]<min_next){
                min_next = nums [i];
                max_l = Math.max(search(i,nums,map)+1,max_l);
            }
        }
        map [startIndex] = max_l;

        return max_l;
    }




}
