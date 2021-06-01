package dynamic_programming_DP.Longest_Common_Subsequence_1143;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String s1 = "skceaxjo";
        String s2 = "acesom";
        String s3 = "abcde";
        String s4 = "ace";
        String s5 = "ezupkr";
        String s6 = "ubmrapg";
        String s7 = "abcdefghi";
        String s8 = "abcdefghi";
//        String s9 = "zelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvc";
//        String s10 = "rwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsj";
        String s9 = "zelohidwdcxilkvytazgfozonw";
        String s10 = "rwjmzoncvihmlmvgdujopwraj";
        String s11 = "oxcpqrsvwf";
        String s12 = "shmtulqrypy";
        String s13 = "abcba";
        String s14 = "abcbcba";
        String s15 = "pqrsvwf";
        String s16 = "qrypy";
        int r = new Solution2().longestCommonSubsequence(s14,s13);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int w = text1.length();
        int l = text2.length();
        int [][] dp = new int [w+1][l+1];
        for(int i = 0;i<w;i++){
            char cur = text1.charAt(i);
            for(int j = 0;j<l;j++){
                if(text2.charAt(j)!=cur){
                    dp [i+1][j+1] = Math.max(dp [i+1][j],dp [i][j+1]);
                    continue;
                }
                dp[i+1][j+1] = dp [i][j] + 1;
            }
        }
        return dp [w][l];
    }

}

