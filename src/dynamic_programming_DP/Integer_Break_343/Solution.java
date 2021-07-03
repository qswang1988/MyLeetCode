package dynamic_programming_DP.Integer_Break_343;

/*
*
*   https://leetcode.com/problems/integer-break/
*   Medium
*
*   Solution:
*
*
* */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int r = new Solution().integerBreak(11);
        System.out.println(r);
    }

    public int integerBreak(int n) {
        int max = 0;
        for(int i = 2;i<=n;i++){
            int average = n/i;
            int remainder = n%i;
            int [] elements = new int [i];
            Arrays.fill(elements,average);
            for(int j = 0;j<remainder;j++)
                elements [j]++;

            int r = 1;
            for(int e:elements)
                r *= e;
            if(r<=max)
                break;
            else
                max = r;
        }
        return max;
    }


}
