package sort.four_fivetyone;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {

    public static void main(String[] args) {
        String input = "tree";
        String r = new Solution2().frequencySort(input);
        System.out.println(r);
    }


    // map is slower than handling array
    public String frequencySort(String s) {
        int [] map = new int [128];
        for(char c:s.toCharArray())
            map [(int)c]++;

        /*PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map[o2] - map[o1];
                    }
                }
        );*/
        //lambda
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (x,y)->map[y] - map [x]
        );

        int index = 0;
        for(int i:map){
            if(i>0)
                queue.offer(index);
            index++;
        }

        StringBuilder r = new StringBuilder(64);
        int c = 0;
        int times = 0;
        while(!queue.isEmpty()){
            c = queue.poll();
            times = map[c];
            while(times>0){
                r.append((char)c);
                times--;
            }
        }

        return r.toString();

    }


}
