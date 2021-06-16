package dynamic_programming_DP.Buy_And_Sell_Stock_121;

/*
*
*   Best time to Buy and sell stock.
*   Easy
*
* */

public class Solution {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int r = new Solution().maxProfit(prices);
        System.out.println(r);
    }

    public int maxProfit(int[] prices) {
        int min = prices [0];
        int diff = 0;
        for(int i = 1;i<prices.length;i++){
            int t = prices [i];
            if(t<min)
                min = t;
            else
                diff = Math.max(diff,t - min);
        }
        return diff;
    }

}
