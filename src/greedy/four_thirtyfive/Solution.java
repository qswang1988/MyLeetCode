package greedy.four_thirtyfive;

import java.util.Arrays;

// start 排序
public class Solution {

    public static void main(String[] args) {
        int [][] t1 = {{1,2},{1,2},{1,2}};
        int [][] t2 = {{1,2},{2,3},{3,4},{1,3}};
        int [][] t3 = {{1,2},{2,3}};
        int [][] t4 = {{1,100},{11,22},{1,11},{2,12}};
        int r = new Solution().eraseOverlapIntervals(t1);
        System.out.println(r);
        /*
        Arrays.sort(t4,
                (x,y)-> {
                    return Integer.signum(x[0] - y[0]);
                }

        );
        for(int [] t:t4){
            System.out.print(t[0]+" "+t[1]+" , ");
        }
        System.out.println();
        */
    }

    //   [[1,2],[1,2],[1,2]]
    //  [[1,2],[2,3],[3,4],[1,3]]
    public int eraseOverlapIntervals(int[][] intervals) {
        int r = 0;  // the result

        // sort intervals, from min to max
        Arrays.sort(intervals,
                (x,y)-> {
                    return Integer.signum(x[0] - y[0]);
                }
        );

        // i is the index of current element we are looking at
        // j is the index of compared element
        int i = 1;
        int j = 0;
        while(i<intervals.length){
            int [] curr = intervals [i];
            int [] cmp = intervals [j];
            if(curr[0] == cmp [0]){
                if(curr[1]<cmp[1]){
                    j = i;
                    i++;
                    r++;
                }else{
                    i++;
                    r++;
                }
            }else{ // can only be curr[0] > cmp [0]
                if(curr[0]<cmp[1]){
                    if(curr[1]>cmp[1]) {
                        i++;
                        r++;
                    }else{
                        j = i;
                        i++;
                        r++;
                    }
                }else{
                    j = i;
                    i++;
                }
            }
        }

        return r;
    }


}
