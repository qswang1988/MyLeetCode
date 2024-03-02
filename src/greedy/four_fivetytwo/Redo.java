package greedy.four_fivetytwo;

import java.util.Arrays;

public class Redo {

    public static void main(String[] args) {
        int [][] b1 = {{10,16},{2,8},{1,6},{7,12}};
        int [][] b2 = {{1,2},{3,4},{5,6},{7,8}};
        int [][] b3 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int r = new Redo().findMinArrowShots(b3);
        System.out.println(r);
    }

    public int findMinArrowShots(int[][] points) {
        //Arrays.sort(points, (int [] a, int [] b) -> {return a [0] - b [0];}); // edge problem
        Arrays.sort(points, (int [] a, int [] b) -> {return Integer.compare(a [0], b [0]);});
        //Arrays.stream(points).forEach(x->{System.out.println("["+x[0] + ","+x[1]+"],");});
        int numOfArrows = 1;
        int right = points [0] [1]; // don't have to care about left side
        for(int i = 1;i<points.length;i++) {
            int [] current = points [i];
            if(current [0] <= right) {
                // there is overlap
                right = current [1] > right ? right : current [1];
            } else {
                // no overlap
                right = current [1];
                numOfArrows++;
            }
        }
        return numOfArrows;
    }

}
