package divide_and_conquer.Beautiful_Array_932;

/*
*
*   https://leetcode.com/problems/beautiful-array/
*   MEDIUM
*
* */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {
//    public static void main(String[] args) {
//        int [] r = new Solution().beautifulArray(5);
//        for(int i:r)
//            System.out.print(i+",");
////        System.out.println(new Solution().pickNumber(1,10));
//
//    }
//
//    Set<Integer> set = new HashSet<>();
//    Random rand = new Random();
//    public int[] beautifulArray(int n) {
//        int [] array = new int [n];
//        divide(array,n,0,n-1);
//        return array;
//    }
//
//    public void divide(int [] nums,int range,int start,int end){
//
//        if(start==end)
//            return;
//
//        if(nums [start] == 0 && nums [end] == 0){
//            nums [start] = pickNumber(1,range);
//            nums [end] = pickNumber(2,range);
//        }else if(nums [start] == 0){
//            int t = nums[end]%2==0?1:2;
//            nums [start] =  pickNumber(t,range);
//        }else{
//            int t = nums[start]%2==0?1:2;
//            nums [end] =  pickNumber(t,range);
//        }
//
//        //if(end - 1 == start)
//        //    return;
//
//        int split = (end - start - 1)/2;
//        divide(nums,range,start,start+split);
//        divide(nums,range,start+split+1,end);
//    }
//
//    // type = 1 : odd
//    // type = 2 : even
//    public int pickNumber(int type,int range){
//        //int r = rand.nextInt(range)+1;
//        int r = 0;
//
//        while(true){
//            r = rand.nextInt(range)+1;
//            if(set.contains(r)||(type==1&&r%2==0)||(type==2&&r%2==1))
//                continue;
//            else
//                break;
//        }
//        set.add(r);
//        System.out.println("added: "+r);
//        return r;
//    }

}
