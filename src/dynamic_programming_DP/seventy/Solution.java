package dynamic_programming_DP.seventy;

public class Solution {
    public static void main(String[] args) {
        int r = new Solution().climbStairs(5);
        System.out.println(r);
    }

    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int p_1 = 1;
        int p_2 = 2;
        for(int i = 3;i<=n;i++){
            int t = p_2;
            p_2 += p_1;
            p_1 = t;
        }
        return p_2;
    }
}
