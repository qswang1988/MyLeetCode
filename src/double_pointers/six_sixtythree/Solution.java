package double_pointers.six_sixtythree;

import javax.xml.transform.Source;

public class Solution {

    public static void main(String[] args) {
        boolean r = new Solution().judgeSquareSum(1000000);
        System.out.println(r);
    }

    public boolean judgeSquareSum(int c) {
        double s = Math.sqrt(c);
        int i = 0;
        int j = (int)s;
        while(j>=i){

            int r = i*i + j*j;
            if(r==c){
                return true;
            }
            else if(r>c){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
