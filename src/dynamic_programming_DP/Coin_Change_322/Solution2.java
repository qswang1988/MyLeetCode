package dynamic_programming_DP.Coin_Change_322;


import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {

        int [] coins = {1,2,5};
        int [] coins1 = {2};
        int [] coins2 = {186,419,83,408};
        int [] coins3 = {1,3,4,7,8};
        int r = new Solution2().coinChange(coins2,6249);
        System.out.println("\n"+r);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount<1)
            return 0;
        int dp [] = new int [amount+1];
        //Arrays.sort(coins);
        for(int c:coins){
            for(int i = 1;i<=amount;i++){
                if(i<c)
                    continue;
                if(i==c){
                    dp[i] = 1;
                    continue;
                }

                if(dp[i-c]==0){
                    //dp [i] = 0;
                    continue;
                }

                if(dp[i]!=0)
                    dp [i] = Math.min(dp[i],dp[i-c]+1);
                else
                    dp [i] = dp[i-c]+1;
            }
            for(int i = 0;i<dp.length;i++){
                System.out.print(i+":"+dp[i]+", ");
            }
            //System.out.println();
        }


        //Arrays.stream(dp).forEach(System.out::println);
//        for(int i = 0;i<dp.length;i++){
//            //System.out.println(i+":"+dp[i]);
//        }
        int r = dp [amount];
        if(r==0)
            return -1;
        return r;
    }
}
