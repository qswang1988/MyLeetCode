package sort.four_fivetyone;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        String input = "tree";
        String r = new Solution().frequencySort(input);
        System.out.println(r);
    }

    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char a:s.toCharArray())
            map.put(a,map.getOrDefault(a,0)+1);

        PriorityQueue<Character> queue = new PriorityQueue<>(
                new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return map.get(o2) - map.get(o1);
                    }
                }
        );

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            queue.offer(entry.getKey());
        }

        StringBuilder r = new StringBuilder(64);
        char c;
        int times = 0;
        while(!queue.isEmpty()){
            c = queue.poll();
            times = map.get(c);
            while(times>0){
                r.append(c);
                times--;
            }
        }

        return r.toString();
    }

}
