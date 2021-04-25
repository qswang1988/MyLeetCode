package search.fourtySeven;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int [] nums2 = {1,2,3};
        int [] nums3 = {2,2,1,1};
        List<List<Integer>> r = new Solution().permuteUnique(nums3);
        System.out.println(r.size());
        for(List<Integer> l : r)
            System.out.println(l);
    }



    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        search(nums,0,permutations);
        return permutations;
    }

    public void search(int [] nums,int pos,List<List<Integer>> permutations){
        //System.out.println("####################### pos "+pos);
        if(pos==nums.length) {
            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0;i<nums.length;i++)
                l.add(nums[i]);
            permutations.add(l);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if(!set.contains(nums [i])) {
                int[] nums_ = Arrays.copyOf(nums, nums.length);
                swap(nums_, i, pos);
                set.add(nums_[pos]);
                search(nums_, pos + 1,permutations);
            }
        }
    }

    public void swap(int [] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
