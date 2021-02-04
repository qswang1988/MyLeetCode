package greedy.six_O_five;

public class Solution {

    public static void main(String[] args) {
        int [] f =  {1,0,0,0,1};
        int n = 1;

        int [] f1 = {1,0,0,0,1};
        int n1 = 2;

        int [] f2 = {1,0,0,0,0,0,1};
        int n2 = 2;

        boolean r = new Solution().canPlaceFlowers(new int [] {0},1);
        System.out.println(r);

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int f_len = flowerbed.length;
        if(f_len<n)
            return false;

        int i = 0;
        while(i<f_len&&n>0){
            if(flowerbed [i]==0){ // no flower in current slot

                if(i+1<f_len){
                    if(flowerbed[i+1]==0){ // next slot is empty, means you can plot here
                        n--;
                        i += 2;
                        continue;
                    }else{                // next slot is planted, so you can move to ....
                        //i++;
                        i+=3;
                        continue;
                    }
                }else if(i==f_len-1) { // you are in the final plot
                    n--;
                    break;
                }else{
                    break;
                }

            }else{ // there is a flower in current slot , go to the greedy.one after next greedy.one.
                i+=2;
            }
        }

        if(n==0)
            return true;
        else
            return false;
    }
}
