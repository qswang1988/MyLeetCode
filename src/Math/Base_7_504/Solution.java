package Math.Base_7_504;
/*
*   https://leetcode.com/problems/base-7/
*   EASY
*
*   100
*   base 10  : 100
*   base 7   : 202
*
* */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if(num==0)
            return "0";
        String plus_minus = "";
        int remains = num;
        if(num<0){
            plus_minus = "-";
            remains = -num;
        }
        StringBuilder sb = new StringBuilder(plus_minus);
        boolean count = false;
        for(int i = 8;i>=0;i--){
            int p = (int)Math.pow(7,i);
            int c = remains/p;
            if(c>0){
                count = true;
                sb.append(c);
                remains %= p;
            }else if(count)
                sb.append("0");
        }
        return sb.toString();
    }
}
