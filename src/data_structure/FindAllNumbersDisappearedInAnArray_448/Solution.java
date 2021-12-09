package data_structure.FindAllNumbersDisappearedInAnArray_448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        List<Integer> l = new Solution().findDisappearedNumbers(nums);
        System.out.println(l);
    }

    /*public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i:nums)
            map.put(i,1);

        for(int i = 1;i<=nums.length;i++){
            if(!map.containsKey(i))
                list.add(i);
        }

        return list;
    }*/

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int [] map = new int [n+1];

        for(int i:nums)
            map [i] = 1;

        List<Integer> list = new ArrayList<>();

        for(int i = 1;i<=n;i++){
            if(map [i] == 0)
                list.add(i);
        }

        return list;
    }
}
