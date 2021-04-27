package search.fourty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> r = new Solution().combinationSum2(candidates,target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        //[1,1,2,5,6,7,10]
        for(int i = 0;i<candidates.length;i++){

        }

        return null;
    }

    public void search(int [] nums,int pos,List<List<Integer>> comb,int sum,List<Integer> list){

    }

}
