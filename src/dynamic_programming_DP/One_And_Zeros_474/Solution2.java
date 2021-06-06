package dynamic_programming_DP.One_And_Zeros_474;

public class Solution2 {
    public static void main(String[] args) {
        String [] str = {"10","0001","111001","1","0"};
        String [] str1 = {"10","0","1"};
        // m '0',  n '1'
        int r = new Solution2().findMaxForm(str,5,3);
        System.out.println(r);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int [m+1][n+1];

        for(String str:strs){
            int [] pair = counter(str);
            int o = pair [0];
            int l = pair [1];

            // from m to o
            for(int j = m;j>=o;j--){
                // from n to l
                for(int k = n;k>=l;k--){
                    if(dp[j - o][k - l] + 1>dp [j][k])
                        dp[j][k] = dp[j - o][k - l] + 1;
                }
            }
        }

        return dp[m][n];
    }

    public int [] counter(String s){
        int [] pair = new int [2];
        for(char c:s.toCharArray()){
            if(c=='0')
                pair [0]++;
            else
                pair [1]++;
        }
        return pair;
    }
}
