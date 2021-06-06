package dynamic_programming_DP.One_And_Zeros_474;

public class Solution {

    public static void main(String[] args) {
        String [] str = {"10","0001","111001","1","0"};
        String [] str1 = {"10","0","1"};
        // m '0',  n '1'
        int r = new Solution().findMaxForm(str,5,3);
        System.out.println(r);
    }

    public int findMaxForm(String[] strs, int m, int n) {

        //int [][][] dp = new int [strs.length+1][m+1][n+1];
        int [][][] dp = new int [strs.length+1][m+1][n+1];
        /*
        *
        *   x = dp [i][j][k]
        *   x : the maximum number of elements of  range 0-i of strs that contains at most j '0' and k '1'.
        * */
        for(int i = 1;i<=strs.length;i++){
        //    System.out.println(counter(strs[i])[0]+","+counter(strs[i])[1]);
            int [] pair = counter(strs[i-1]);
            int o = pair [0];
            int l = pair [1];
            if(o>m||l>n){
                dp [i] = dp [i-1];
                continue;
            }

            for(int j = 0;j<=m;j++){
                for(int k = 0;k<=n;k++){
                    //System.out.println("j:"+j+",k:"+k+",+pair[0]:"+pair[0]+",pair[1]:"+pair[1]);
                    if(k>=l&&j>=o) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - o][k - l] + 1);
                    }else
                        dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }

        for(int i = 0;i<dp.length;i++){
            if(i>0)
                System.out.println("i:"+i+", "+strs[i-1]);
            for(int j = 0;j<dp[i].length;j++){
                System.out.println();
                for(int k = 0;k<dp[i][j].length;k++){
                    System.out.print(dp[i][j][k]+",");
                }
            }
            System.out.println();
            System.out.println();
        }

        return dp[strs.length][m][n];
    }

    public int [] counter(String s){
        int m = 0;
        int n = 0;
        for(char c:s.toCharArray()){
            if(c=='0')
                m++;
            else
                n++;
        }
        int [] pair = {m,n};
        return pair;
    }

}
