package dynamic_programming_DP.Maximum_Length_of_Pair_Chain_646;

/*
*   https://leetcode.com/problems/maximum-length-of-pair-chain/
*   MEDIUM
*
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int [][] pairs = {{1,2},{7,8},{4,5}};
        int r = new Solution().findLongestChain(pairs);
        System.out.println(r);
    }

    public int findLongestChain(int[][] pairs) {

        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int [] p:pairs)
            queue.offer(p);

        int len = 1;
        int t = queue.poll() [1];

        while(!queue.isEmpty()){
            int [] q = queue.poll();

            if(q[0]>t){
                len++;
                t = q [1];
                continue;
            }

            if(q[1]<t)
                t = q [1];
        }

        return len;
    }
}
