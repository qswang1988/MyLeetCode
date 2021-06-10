package dynamic_programming_DP.Edit_Distance_72;

public class Solution {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        String word3 = "intention";
        String word4 = "execution";
        String word5 = "zoologicoarchaeologist";
        String word6 = "zoogeologist";
        String word7 = "kitten";
        String word8 = "sitting";
        int r = new Solution().minDistance(word5,word6);
        System.out.println(r);
    }

    public int minDistance(String word1, String word2) {
        String temp = word2;
        word2 = word1;
        word1 = temp;
        int len_x = word1.length()+1;
        int len_y = word2.length()+1;
        int [][] dp = new int [len_x][len_y];
        char[] word1_ = word1.toCharArray();
        char[] word2_ = word2.toCharArray();
        for(int i = 0;i<len_x;i++)
            dp [i][0] = i;
        for(int j = 0;j<len_y;j++)
            dp [0][j] = j;

        for(int i = 1;i<len_x;i++){
            for(int j = 1;j<len_y;j++){
                if(word1_[i-1] == word2_[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                dp [i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                if(i==j)
                    dp[i][j] = Math.min(dp[i][j],i);

                if(dp[i][j] - dp[i-1][j-1]>1)
                    dp[i][j] = dp[i-1][j-1]+1;
            }
        }
        return dp[len_x-1][len_y-1];
    }


}
