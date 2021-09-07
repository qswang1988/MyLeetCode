package Math.Power_Of_Three_326;

/*
*   https://leetcode.com/problems/power-of-three/
*   EASY
* */

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        if(n==1)
            return true;
        else if(n<3)
            return false;
        else if(n%3>0)
            return false;
        else if(n/3>0)
            return isPowerOfThree(n/3);
        else
            return true;
    }
}
