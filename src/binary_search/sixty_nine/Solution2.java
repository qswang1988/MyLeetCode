package binary_search.sixty_nine;

public class Solution2 {

    public static void main(String[] args) {
        //2147395599
        int r = new Solution2().mySqrt(2147395599);
        System.out.println(r);
    }

    public int mySqrt(int x) {
        if(x==1)
            return 1;
        int left = 0;
        int right = x;
        while(right-left>1){
            int half = (right+left)/2;
            //System.out.println("left: "+left+",right: "+right+",half: "+half);
            if((long)half*half==x)
                return half;
            else if((long)half*half>x)
                right = half;
            else
                left = half;
        }
        return left;
    }
}
