package data_structure.Sliding_Window_Maximum_239;

import java.util.*;

/*
*
*   https://leetcode.com/problems/sliding-window-maximum/
*   Hard
*
* */
public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int [] nums2 = {1,-1};
        int [] nums3 = {1,3,1,2,0,5};
        int [] r = new Solution().maxSlidingWindow(nums3,3);
        Arrays.stream(r).forEach(x->System.out.print(x+" "));
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        LinkedList<int []> list = new LinkedList<>();
        int len = nums.length;
        int pointerL = 0;
        int pointerR = len>k?k-1:len-1;
        for(int i = 0;i<=pointerR;i++){
            int [] n = new int[]{i, nums[i]};
            while (!list.isEmpty()&&n[1]>list.getLast()[1])
                list.removeLast();
            list.add(n);
        }
        if(len<=k)
            return new int [] {list.getFirst()[1]};
        int [] r = new int [len - k + 1];
        r [0] = list.getFirst()[1];
        pointerL++;
        pointerR++;

        int index = 1;
        while(pointerR<len){
            if(list.getFirst()[0]<pointerL)
                list.removeFirst();
            int [] n = new int[]{pointerR, nums[pointerR]};
            while (!list.isEmpty()&&n[1]>list.getLast()[1])
                list.removeLast();
            list.add(n);
            r[index] = list.getFirst()[1];
            index++;
            pointerL++;
            pointerR++;
        }
        return r;
    }

// Priority Queue
/*    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { return o2[1] - o1[1];}
        });

        int len = nums.length;
        int pointerL = 0;
        int pointerR = len>k?k-1:len-1;

        for(int i = 0;i<=pointerR;i++)
            queue.add(new int [] {i,nums[i]});

        if(len<=k)
            return new int [] {queue.peek()[1]};

        int [] r = new int [len - k + 1];
        int index = 0;
        while(pointerR<len){

            int [] max = queue.peek();
            if(max [0]<pointerL){
                queue.poll();
                continue;
            }

            r [index] = max[1];

            if(pointerR<len-1){
                int [] next = new int [] {pointerR+1,nums[pointerR+1]};
                queue.add(next);
            }

            pointerL++;
            pointerR++;
            index++;
        }

        return r;
    }*/

}
