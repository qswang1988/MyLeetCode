package data_structure.Two_Sum_1;

import Math.Minimum_Moves_to_Equal_Array_Elements_II_462.Solution2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*   https://leetcode.com/problems/two-sum/
* */
public class Solution {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int [] nums2 = {-3,4,3,90};
        int [] r = new Solution().twoSum(nums2,0);
        Arrays.stream(r).forEach(x->System.out.print(x+","));
    }

    public int[] twoSum(int[] nums, int target) {
        int r [] = new int [2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int t = nums [i];
            int needs = target - t;
            if(map.containsKey(needs)){
                r [0] = map.get(needs);
                r [1] = i;
                break;
            }
            map.put(t,i);
        }
        return r;
    }
}
