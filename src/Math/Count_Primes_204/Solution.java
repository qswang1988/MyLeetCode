package Math.Count_Primes_204;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*   https://leetcode.com/problems/count-primes/
*   Easy
*
* */
public class Solution {
    public static void main(String[] args) {
        //System.out.println(new Solution().countPrimes(3));
    }

    public int countPrimes(int n) {
        if(n<=2)
            return 0;

        boolean [] primes = new boolean[n+1];
        Arrays.fill(primes,true);

        int NumOfPrimes = n - 2;
        for(int i = 2;i<n;i++){
            if(!primes [i])
                continue;
            int prod = i*i;
            if(prod<0 || prod>=n)
                prod = n;
            for(int j = prod;j<n;j++){
                if(!primes [j])
                    continue;
                if(j%i==0){
                    primes [j] = false;
                    NumOfPrimes--;
                }
            }
        }
        return NumOfPrimes;
    }

}
