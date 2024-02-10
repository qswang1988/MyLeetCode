package greedy.one_thirtyfive;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Redo {
    public static void main(String[] args) {
        int [] ratings = {1,0,2};
        int [] ratings2 = {1,2,2};
        int [] ratings3 = {1,2,87,87,87,2,1};
        int [] ratings4 = {1,3,4,5,2};

        int sum = new Redo().candy(ratings4);
        System.out.println(sum);
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int [] candies = new int [len];
        Arrays.fill(candies,1);

        for(int i = 1;i<len;i++) {
            if(ratings [i] > ratings [i-1]) {
                candies [i] = candies [i-1] + 1;
            }
        }
        //System.out.println(Arrays.stream(candies).boxed().collect(Collectors.toList()));
        int sum = candies [len - 1];
        for(int i = len - 2; i >= 0; i--) {
            if(ratings [i] > ratings [i + 1]) {
                candies [i] = Math.max(candies [i + 1] + 1,candies [i]);
            }
            sum += candies [i];
        }
        //System.out.println(Arrays.stream(candies).boxed().collect(Collectors.toList()));
        return sum;
        //return Arrays.stream(candies).sum();
    }
}
