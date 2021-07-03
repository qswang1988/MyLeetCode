package dynamic_programming_DP.Delete_Operation_for_Two_Strings_583;

/*
*   https://leetcode.com/problems/delete-operation-for-two-strings/
*   MEDIUM
*
* */

public class Solution {
    public static void main(String[] args) {
        String word1 = "eat";
        String word2 = "sea";
        String word3 = "leetcode";
        String word4 = "etco";
        int r = new Solution().minDistance(word3,word4);
        System.out.println(r);
    }


    public int minDistance(String word1, String word2) {
        int len1 = word1.length()+1;
        int len2 = word2.length()+1;

        int [][] dp = new int[len1][len2];
        //dp [0][0] = 0;
        for(int i = 1;i<len2;i++)
            dp[0][i] = i;

        for(int i = 1;i<len1;i++)
            dp [i][0] = i;

        for(int i = 1;i<len1;i++){
            for(int j = 1;j<len2;j++){
                int m = Math.min(dp[i-1][j],dp[i][j-1])+1;
                m = Math.min(m,dp[i-1][j-1]+2);

                if(word1.charAt(i-1)==word2.charAt(j-1))
                    m = Math.max(m-2,dp[i-1][j-1]);

                dp [i][j] = m;
            }
        }

        return dp [len1-1][len2-1];
    }


}
