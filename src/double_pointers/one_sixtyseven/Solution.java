package double_pointers.one_sixtyseven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// 此题双指针的解法无法应对 [3,3] 这种有重复的输入
public class Solution {


    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int [] nums1 = {3,3};
        int target = 9;
        int [] r = new Solution().twoSum(nums,target);
        System.out.println(r);
    }


    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int sum = nums[i]+nums[j];
            if(sum == target){
                return new int [] {i+1,j+1};
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[] {-1,-1};
    }
}
