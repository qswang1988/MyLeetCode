package dynamic_programming_DP.Longest_Increasing_Subsequence_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        int [] nums1 = {1,2,3,4,5,6,7,8,9,10};
        int [] nums3 = {2,15,3,7,8,6,18};
        int r = new Solution2().lengthOfLIS(nums);
        System.out.println(r);
    }

    public int lengthOfLIS(int[] nums) {
        //Map<Integer,Integer> map = new HashMap<>();
        // array is more efficient in this case
        int [] dp = new int [nums.length];
        Arrays.fill(dp,1);
        int max_len = 1;
        for(int i = 0;i<nums.length;i++){
            if(i<nums.length-1&&nums [i]>=nums[i+1])
                continue;
            int len = 0;
            for(int j = 0;j<i;j++){
                if(nums [j]<nums [i] && dp [j]>len)
                    len = dp [j];
            }
            dp [i] = len+1;
            max_len = Math.max(len+1,max_len);
        }

        return max_len;
    }


}
