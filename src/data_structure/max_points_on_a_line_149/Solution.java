package data_structure.max_points_on_a_line_149;

import java.text.DecimalFormat;
import java.util.*;

/*
*   https://leetcode.com/problems/max-points-on-a-line/
*   HARD
*
* */
public class Solution {
    public static void main(String[] args) {
        int [][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int [][] points2 = {{3,3},{1,4},{1,1},{2,1},{2,2}};
        int [][] points3 = {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        int r = new Solution().maxPoints(points2);
        System.out.println(r);
    }

    // if K(firstp,thirdp) == K(secondp,thirdp)
    // then firstp,secondp, and the thirdp are on the same straight line, counts++
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len<=2)
            return len;
        int max = 2;
        for(int i = 0;i<len;i++){
            int [] p1 = points [i]; // first point
            for(int j = i+1;j<len;j++){
                int counts = 2;// at least 2
                int [] p2 = points [j]; // second point
                for(int m = j+1;m<len;m++){
                    int [] p3 = points [m]; // third point
                    double denominator = p3[0] - p2 [0] ;
                    double denominator_ = p3[0] - p1[0];
                    if(denominator_ == 0 && denominator == 0){
                        counts++;
                        continue;
                    }
                    double nominator = p3 [1] - p2 [1];
                    double nominator_ = p3 [1] - p1 [1];
                    if(nominator/denominator == nominator_/denominator_)
                        counts++;
                }
                max = Integer.max(max,counts);
            }
        }
        return max;
    }
}