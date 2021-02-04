package greedy.one_twentytwo;

public class Solution {

    public static void main(String[] args) {
        int [] in = {7,1,5,3,6,4};
        int [] in1 = {1,2,3,4,5};
        int [] in2 = {7,6,4,3,1};
        int r = new Solution().maxProfit(in2);
        System.out.println(r);
    }

    // 这题只需要计算后一天比之前大的情况的DIFFERENCE的总和就可以了。不用考虑具体哪天卖哪天买。
     /*
     *  [1,3,5,2,1,6]
     *  比如这个例子
     *  3-1 = 2
     *  5-3 = 2
     *  6-1 = 5
     *  这几个数字加起来，就等同于第一天买第三天卖 （4 = 2+2 ）
     *  和 第五天买第六天卖 （5）
     *
     * */
    public int maxProfit(int[] prices) {

        int r = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                r += prices[i]-prices[i-1];
            }
        }

        return r;
    }

}
