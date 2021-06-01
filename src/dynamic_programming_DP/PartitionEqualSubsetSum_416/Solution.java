package dynamic_programming_DP.PartitionEqualSubsetSum_416;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,5,11,5};
        int [] nums1 = {1,2,3,5};
        int [] nums2 = {1,2,5};
        int [] nums3 = {1,2,3,4,5,6,7};
        int [] nums4 = {23,13,11,7,6,5,5};
        boolean r = new Solution().canPartition(nums4);
        System.out.println(r);
    }

    /*

         num = [1,5,11,5], sum = 22
         target = sum/2 = 11

         we change the question to another question
         find if N elements of num that can be added up to target(11)

         0 1 2 3 4 5 6 7 8 9 10 11
       0 y y
       1 y y         y
       2 y y         y
       3 y y         y          y



    *
     */

    public boolean canPartition(int[] nums) {
        if(nums.length<2)
            return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        if(sum%2==1)
            return false;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int n:nums)
            map.put(n,0);

        Queue<Integer> l = new LinkedList<Integer>();
        int maxJ = 0;
        for(int i = 0;i<nums.length;i++){
            int t = nums [i];
            if(t>target)
                return false;
            for(int j = t;j<=Math.min(target,maxJ+t);j++){
                //if(map.containsKey(j))
                //    continue;
                if(map.containsKey(j-t)){
                    //System.out.println("t:"+t+",j:"+j+", "+map);
                    if(j==target)
                        return true;
                    l.add(j);
                    if(j>maxJ)
                        maxJ = j;
                }
            }
            while(!l.isEmpty())
                map.put(l.poll(),0);
            l.clear();
        }
        return false;
    }

}
