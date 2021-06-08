package dynamic_programming_DP.Coin_Change_322;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int [] coins = {1,2,5};
        int [] coins1 = {2};
        int [] coins2 = {186,419,83,408};
        int [] coins3 = {1,3,4,7,8};
        int r = new Solution().coinChange(coins,11);
        System.out.println("\n"+r);

    }

    public int coinChange(int[] coins, int amount) {
        if(amount<1)
            return 0;
        int dp [] = new int [amount+1];
        for(int i = 1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int c:coins){
                if(i<c)
                    continue;
                int f = dp[i-c];
                if(i>c&&f==0)
                    continue;
                min = Math.min(min,f);
            }
            dp [i] = min==Integer.MAX_VALUE?0:min+1;

        }

        //Arrays.stream(dp).forEach(System.out::print);
        int r = dp [amount];
        if(r==0)
            return -1;
        return r;
    }

}
