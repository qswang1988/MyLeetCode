package data_structure.Longest_Consecutive_Sequence_128;

import java.util.*;

/*
*   https://leetcode.com/problems/longest-consecutive-sequence/
*   Medium
*
* */
public class Solution {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        int [] nums2 = {1,2,0,1};
        int r = new Solution().longestConsecutive(nums);
        System.out.println(r);
    }

    // Solutoin 2, HashSet
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();

        for(int i:nums)
            set.add(i);

        int longest = 1;
        int con = 1;

        for(int i : set) {
            // if the value equals to itself minus one, it means the current value has been counted previously. And it won't make longest consecutive number than the one before it. So we skip it.
            if(set.contains(i-1))
                continue;
            int curr = i;
            while(set.contains(++curr))
                con++;

            longest = Integer.max(longest,con);
            con = 1;
        }
        return longest;
    }

    // Solution1. PriorityQueue
/*    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { return o1 - o2; }
        });

        for(int i:nums)
            queue.add(i);

        int longest = 1;
        int con = 1;
        int last = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int i = queue.poll();
            //System.out.println("curr: "+i);
            if(i == last)
                continue;
            else if(i - last == 1)
                con++;
            else
                con = 1;
            longest = Integer.max(longest, con);
            last = i;
        }
        return longest;
    }*/
}
