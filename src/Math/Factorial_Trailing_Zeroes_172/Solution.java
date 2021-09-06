package Math.Factorial_Trailing_Zeroes_172;
/*
*
*   https://leetcode.com/problems/factorial-trailing-zeroes/
*   EASY
*
* */
public class Solution {
    public static void main(String[] args) {
        int r = new Solution().trailingZeroes(25);
        System.out.println(r);
    }

    public int trailingZeroes(int n) {
        if(n==0)
            return n;
        return n/5 + trailingZeroes(n/5);
    }

/*    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 0;i<=n;i+=5){
            int m = i;
            while(m>4){
                m = m/5;
                count++;
                if(m%5>0)
                    break;
            }
        }
        return count;
    }*/


    /*// 1,2,3,4,5,6,7,8,9
    public int trailingZeroes(int n) {
        if(n<=1)
            return 0;
        int count = 0;
        int product = 1;
        int i = 2;
        while(i<=n){

            product *= i;
            while(product%10==0){
                product = product/10;
                count++;
            }

            if(product>100000)
                product = product%10000;

            int m = i%10;
            if(m==0)
                i+=2;
            else if(m==2)
                i+=3;
            else
                i+=5;
        }
        return count;
    }*/


}
