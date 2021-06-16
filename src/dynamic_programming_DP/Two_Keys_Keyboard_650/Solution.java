package dynamic_programming_DP.Two_Keys_Keyboard_650;

/*
*   https://leetcode.com/problems/2-keys-keyboard/
*   Medium
*
* */

public class Solution {

    public static void main(String[] args) {
        int r = new Solution().minSteps(8);
        System.out.println(r);
    }

    public int minSteps(int n) {
        if(n<2)
            return 0;
        int m = 2,times = 2,clipboard = 1;
        while(m<n){
            int gap = n - m;
            if(gap==clipboard){
                times++;
                break;
            }
            //if(gap%m==0&&((gap/m)+1)<gap/clipboard){
            if(gap%m==0){
                times+=2;
                clipboard = m;
                m+=m;
                continue;
            }
            m+=clipboard;
            times++;
        }
        return times;
    }
}
