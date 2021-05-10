package dynamic_programming_DP.Decode_ways_91;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s = "2122";
        String s1 = "10011";
        String s2 = "2611055971756562";
        String s3 = "1217175";
        String s4 = "26110";
        int r = new Solution().numDecodings("10");
        System.out.println(r);
    }

    public int numDecodings(String s) {
        char [] chars = s.toCharArray();
        if(chars [0]=='0')
            return 0;
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(chars [0] - '0');
        for(int i = 1;i<s.length();i++){
            int t = chars [i] - '0';
            if(t>0){
                nums.add(t);
                continue;
            }

            int last = nums.get(nums.size() - 1);
            if (last > 2)
                return 0;
            nums.set(nums.size() - 1, last * 10);
        }

        int nums_of_combination = 1;
        int previous_of_combination = 1;
        for(int i = 1;i<nums.size();i++){
            if(nums.get(i)>9||(nums.get(i-1)*10+nums.get(i))>26){
                previous_of_combination = nums_of_combination;
                continue;
            }
            int new_comb = nums_of_combination + previous_of_combination;
            previous_of_combination = nums_of_combination;
            nums_of_combination = new_comb;
        }
        return nums_of_combination;
    }

}
