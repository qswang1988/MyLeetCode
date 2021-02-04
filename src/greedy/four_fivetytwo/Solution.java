package greedy.four_fivetytwo;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int [][] t1 = {{10,16},{2,8},{1,6},{7,12}};
        int [][] t2 = {{1,2},{3,4},{5,6},{7,8}};
        int [][] t3 = {{1,2},{2,3},{3,4},{4,5}};
        int [][] t4 = {{1,8},{5,6},{1,5},{4,9}};
        int [][] t5 = {{1,2}};
        int [][] t6 = {{2,3},{2,3}};
        int [][] t7 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int [][] t8 = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int r = new Solution().findMinArrowShots(t8);
        System.out.println(r);
        //System.out.println();
        /*
        Arrays.sort(t4,(x,y)-> {
            if(x [0] == y[0]){
                return Integer.signum(x [1] - y [1]);
            }
            return Integer.signum(x[0] - y[0]);
        });
        Arrays.stream(t4).forEach(x-> System.out.println(x[0]+" "+x[1]+ " , "));

         */
    }
    // start 排序
    public int findMinArrowShots(int[][] points) {

        if(points.length==0)
            return 0;

        Arrays.sort(points,(x,y)-> {
            return Integer.compare(x[0], y[0]);
        });
        Arrays.stream(points).forEach(x-> System.out.print(x[0]+" "+x[1]+ " ,\n"));
        int r = 1;
        int i = 1;
        int [] inter = points [0];
        while(i<points.length){
            if(points[i][0]>inter[1]){
                inter = points [i];
                r++;
                i++;
            }else if(points[i][0] == inter[1]){
                inter = new int [] {inter[1],inter[1]};
                i++;
            }else{ // points[i][0] < inter[1]
                inter = new int [] {points [i][0],Integer.min(points[i][1],inter [1])};
                i++;
            }
        }

        return r;
    }
}
