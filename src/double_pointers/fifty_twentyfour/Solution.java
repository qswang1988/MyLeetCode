package double_pointers.fifty_twentyfour;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String test = "abpcplea";
        String [] d = {"ale","apple","monkey","plea"};
        String [] d2 = {"a","b","c"};
        List list = Arrays.asList(d2);
        String r = new Solution().findLongestWord(test,list);
        System.out.println(r);
    }

    public String findLongestWord(String s, List<String> d) {
        // sort based on length, from longer str to shorter str
        Collections.sort(d,(s1,s2)-> s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2));
        /*Collections.sort(d, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });*/
        //d.stream().forEach(x-> System.out.println(x));

        for(String str:d){
            if(str.length()>s.length())
                continue;
            int count = 0;
            int pointer = 0;
            for(int i = 0;i<str.length()&&pointer<s.length()&&count<=str.length();pointer++){
                if(str.charAt(i)==s.charAt(pointer)){
                    count++;
                    i++;
                }
            }
            if(count>=str.length())
                return str;
        }

        return "";
    }
}
