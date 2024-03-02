package greedy.four_thirtyfive;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Redo {
    public static void main(String[] args) {
        int [][] input1 = {{1,2},{2,3},{3,4},{1,3}};
        int [][] input2 = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        int r = new Redo().eraseOverlapIntervals(input2);
        System.out.println(r);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        // sort by each range's start
        Arrays.sort(intervals,
                (int [] a, int [] b) -> {return a[0] - b[0];});

        int pointer = 0;// to be compared with the next one
        int count = 0;
        for(int i = 0; i < len - 1; i++) {
            // compare each range's end, keep the shorter one
            int currentEnd = intervals[pointer][1];
            int[] next = intervals[i + 1];
            int nextStart = next[0];
            int nextEnd = next[1];

            if (nextStart < currentEnd) { // overlap
                if (currentEnd > nextEnd) {
                    pointer = i + 1;
                }
                count++;
            } else { // no overlap
                pointer = i + 1;
            }
        }

        return count;
    }
}
