package dynamic_programming_DP.four_thirteen;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,3,5,7,9};
        int [] nums2 = {7,7,7,7};
        int [] nums3 = {3,-1,-5,-9};
        int [] nums4 = {1,3,5,5,6,7,8};
        int r = new Solution().numberOfArithmeticSlices(nums4);
        System.out.println(r);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;
        int num_of_subsequence = 0;
        int start = 0;
        int end = 1;
        int interval = nums [1] - nums [0];
        for(int i = 1;i<nums.length;i++){
            int inter = nums [i] - nums [i-1];
            //System.out.println("start: "+start+",end: "+end +",interval: "+interval+",inter: "+inter);
            if(inter == interval) {
                end = i;
                if(i == nums.length - 1)
                    num_of_subsequence+=check_subs(nums,start,end);
                continue;
            }else if(end - start>=2){
                num_of_subsequence+=check_subs(nums,start,end);
            }
            start = end;
            end = i;
            interval = nums [i] - nums [i-1];
        }
        return num_of_subsequence;
    }

    public int check_subs(int[] nums,int start,int end){
        //System.out.println("check sub: start: "+start+",end: "+end);
        int last_num = 1;
        for(int i = start + 3;i<=end;i++)
            last_num += i - start - 1;
        //last_num = (i-2-start)+last_num + 1;
        return last_num;
    }


}
