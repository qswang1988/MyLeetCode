package binary_search.sixty_nine;

public class Solution {
    public static void main(String[] args) {
        // 2147395599
        int r = new Solution().mySqrt(2147395599);
        System.out.println(r);

    }

    public int mySqrt(int x) {
        if(x==1)
            return 1;
        long left = 0;
        long right = x/2+1;
        //int i = 0;

        while(true){
            //i++;
            long half = left + (right-left)/2;
            long product = half*half;
            //System.out.println("left: "+left+",right: "+right+",half: "+half+",product of half: "+product);
            if(product == x)
                return (int)half;
            else if(product>x){
                right = half;
            }else{

                if(left==half) {
                    /*if(left==right-1)
                        return right;
                    else*/
                        return (int)left;
                }
                left = half;
            }
            continue;
        }

        //return left;
    }

}
