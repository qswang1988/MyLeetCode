package search.fourty;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int [] candidates2 = {3,1,3,5,1,1};
        int target = 8;
        List<List<Integer>> r = new Solution().combinationSum2(candidates,target);
        System.out.println("r.size: "+r.size());
        System.out.println(r);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();

        int [] nums = {};
        for(int i = 0;i<candidates.length;i++){
            if(candidates[i]<=target){
                nums = Arrays.copyOf(nums,nums.length+1);
                nums [nums.length-1] = candidates [i];
            }
        }
        Arrays.sort(nums);
        search(nums,0,combinations,0,target);

        return combinations;
    }

    public void search(int [] nums,int pos,List<List<Integer>> comb,int sum, int target){
        List<Integer> thisround = new ArrayList<>();
        for(int i = pos;i<nums.length;i++){
            if((pos>0&&nums [i]<nums [pos-1])||thisround.contains(nums [i]))
                continue;

            int sum_ = sum + nums [i];
            if(sum_ == target){
                List<Integer> list = new ArrayList<>();
                for(int j = 0;j<pos;j++)
                    list.add(nums[j]);
                list.add(nums[i]);
                comb.add(list);
                return;
            }

            if(sum_>target) // *put it here before handling arrays
                return;     // *it doesn't have to continue, because the following elemtns are larger than this, so the sum will be larger than target definitely

            int [] nums_ = Arrays.copyOf(nums,nums.length);
            swap(nums_,pos,i);
            thisround.add(nums_ [pos]);
            search(nums_, pos + 1, comb, sum_, target);

        }
    }

    public void swap(int [] nums,int x, int y){
        int temp = nums [x];
        nums [x] = nums [y];
        nums [y] = temp;
    }

}
