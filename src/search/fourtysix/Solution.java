package search.fourtysix;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int [] nums2 = {1,2,3,4};
        List<List<Integer>> list = new Solution().permute(nums2);
        System.out.println(list.size());
        for(List<Integer> l:list){
            l.stream().forEach(System.out::print);
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        calc(list,nums,0);
        return list;
    }

    public void calc(List<List<Integer>> list,int nums[],int pos){
        int rest = nums.length-pos;
        if(rest == 0){
            List<Integer> l = new ArrayList<>();
            for(int i:nums)
                l.add(i);
            list.add(l);
            return;
        }

        for(int i = pos;i<nums.length;i++){
            int [] array = Arrays.copyOf(nums,nums.length);
            if(i!=pos){
                int temp = array [pos];
                array [pos] = array [i];
                array [i] = temp;
            }
            calc(list,array,pos+1);
        }
    }

}
