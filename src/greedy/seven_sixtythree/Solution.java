package greedy.seven_sixtythree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";
        String s2 = "qiejxqfnqceocmy";

        int i = 0;
        for(char s:s1.toCharArray()){
            System.out.println(i+" : "+s1.lastIndexOf(s));
            i++;
        }

        //List<Integer> r = new Solution().partitionLabels(s1);
        //r.stream().forEach(x->System.out.println(x));
        //System.out.println(s1.substring(0,4));
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> r = new ArrayList<>();
        int last_split = -1;
        int i = 0;
        while(i<S.length()){
            char char_i = S.charAt(i);
            //System.out.println("char_i: "+char_i);
            int last_index = S.lastIndexOf(char_i);
            //System.out.println("last_index: "+last_index);

            int l_sub_index = last_index;
            for(int j = i;j<l_sub_index;j++){
                int i1 = S.lastIndexOf(S.charAt(j));
                if(i1 >l_sub_index) {
                    l_sub_index = i1;
                }
            }
            //System.out.println();
            int max = Integer.max(last_index,l_sub_index);
            System.out.println(": "+S.substring(last_split+1,max+1));
            //System.out.println("after this round: i:"+i+" max:"+max+" last_split:"+last_split);
            r.add(max - last_split);
            last_split = max;
            i = max+1;
        }

        return r;
    }
}
