package greedy.seven_sixtythree;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";
        String s2 = "qiejxqfnqceocmy";

        /*
        int i = 0;
        for(char s:s1.toCharArray()){
            System.out.println(s+" "+ i+" : "+s1.lastIndexOf(s));
            i++;
        }

         */

        List<Integer> r = new Solution2().partitionLabels(s1);
        r.stream().forEach(x->System.out.println(x));
        //System.out.println(s1.substring(0,4));
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> r = new ArrayList<>();
        int i = 0;
        //Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int [] array = new int [S.length()];
        for(char s:S.toCharArray()){
            System.out.println(i+" : "+s+" ,"+S.lastIndexOf(s));
            array [i] = S.lastIndexOf(s);
            i++;
        }

        int j = 0;
        int max = 0;
        int mark = -1;
        while(j<S.length()){
            if(max==0)
                max = array[j];
            if(array [j]>=max && j>=max){
                System.out.println("j: "+ j +" mark: " + mark);
                r.add(j - mark);
                max = 0;
                mark = j;
                j++;
                continue;
            }
            if(array[j]>max){
                max = array[j];
            }
            j++;
        }
        return r;
    }
}
