package dynamic_programming_DP.Perfect_Squares_279;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int r = new Solution().numSquares(12);
        System.out.println(r);
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int sqrt = (int)Math.sqrt(n+1);
        for(int i = 1;i<=sqrt+1;i++){
            int m = i*i;
            list.add(m);
            map.put(m,1);
        }
        return calc(list,n,map);
    }

    public int calc(List<Integer> list,int num,Map<Integer,Integer> map){
        if(map.containsKey(num))
            return map.get(num);
        int min = Integer.MAX_VALUE;
        for(int i = 0;list.get(i)<num;i++){
            int sum = 0;
            int element = list.get(i);
            sum = num/element;
            int r = num%element;
            if(r>0)
                sum += calc(list,r,map);
            if(sum<min)
                min = sum;
            if(min==2)
                break;
        }
        map.put(num,min);
        return min;
    }


}
