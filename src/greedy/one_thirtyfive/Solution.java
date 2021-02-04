package greedy.one_thirtyfive;

public class Solution {

    public static void main(String[] args) {
        int [] t = {1,0,2};
        int [] t2 = {1,2,2};
        int [] t3 = {1,3,4,5,2};
        int r = new Solution().candy(t3);
        System.out.println(r);
    }
    /*
    *   从左往右一次，从右往左一次。每次都只考虑单方向。
    *   从左往右： 基本是1，遇到当前的数字大于左边的，就将当前分配 = 左边分配+1
    *
    *   从右往左： 基本不变。只有遇到 当前比右边的大 && 但当前分配 <= 右边分配 时，纠正。
    *   将当前分配 = 右边分配+1
    *
    * */
    public int candy(int[] ratings) {
        int k = 0;
        int len = ratings.length;
        int [] r = new int [len];
        // from left to right
        r [0] = 1;
        for(int i = 1;i<len;i++){
            if(ratings[i]>ratings[i-1])
                r [i] = r [i-1] +1;
            else
                r [i] = 1;
        }
        for(int j : ratings)
            System.out.print(j+" ");
        System.out.println("\n- - - ");
        for(int j : r)
            System.out.print(j+" ");
        System.out.println();
        // from right to left
        for(int i = len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&r[i]<=r[i+1])
                r [i] = r[i+1]+1;
        //    else
        //        r [i] = 1;
        }
        for(int j : r)
            System.out.print(j+" ");
        System.out.println();
        int sum = 0;
        for(int j : r)
            sum += j;

        return sum;
    }
}
