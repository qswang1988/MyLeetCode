package Random.Ten;

import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        Pattern pattern_s = Pattern.compile("[a-z]{1,20}");
        Pattern pattern_p = Pattern.compile("[\\.\\*a-z]{1,30}");

        if(!pattern_s.matcher(s).matches()||!pattern_p.matcher(p).matches()) {
            return false;
        }

        if(Pattern.matches("^\\*",p) || Pattern.matches("\\*\\*",p)) {
            return false;
        }

        int pointer_s = 0;
        int pointer_p = 0;

        char [] ss = s.toCharArray();
        char [] ps = p.toCharArray();

        boolean r = true;

        while(pointer_s < ss.length || pointer_p < ps.length) {

            /*if(pointer_p == ps.length && ps [pointer_p] == '*') {
                --pointer_p;
            } else {
                return false;
            }

            if(pointer_s == ss.length) {
                return ss [ss.length - 1] == ps [ps.length - 1];
            }*/

            if(ss [pointer_s] == ps [pointer_p] || ps [pointer_p] == '.') {
                pointer_s++;
                pointer_p++;
                continue;
            }

            if(ps [pointer_p] == '*') {

            } else {

            }


        }

        return r;
    }
}
