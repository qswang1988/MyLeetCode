package dynamic_programming_DP.Longest_Common_Subsequence_1143;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s1 = "skceaxjo";
        String s2 = "acesom";
        String s3 = "abcde";
        String s4 = "ace";
        String s5 = "ezupkr";
        String s6 = "ubmrapg";
        String s7 = "abcdefghi";
        String s8 = "abcdefghi";
//        String s9 = "zelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvc";
//        String s10 = "rwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsj";
        String s9 = "zelohidwdcxilkvytazgfozonw";
        String s10 = "rwjmzoncvihmlmvgdujopwraj";
        System.out.println(new Solution().longestCommonSubsequence(s1,s2));
    }

    private int max_len;
    public int longestCommonSubsequence(String text1, String text2) {
        max_len = 0;
        String longer = (text1.length()>text2.length())?text1:text2;
        String shorter = (longer.equals(text1))?text2:text1;

        Map<Character,Integer> map = new HashMap<>();
        List<Character> commons = new ArrayList<Character>();
        for(char s:longer.toCharArray())
            map.put(s,1);
        for(char s:shorter.toCharArray()) {
            if(map.containsKey(s))
                commons.add(s);
        }

        System.out.println(longer);
        System.out.println(shorter);
        System.out.println("commons: "+commons);
        for(int i = 0;i<commons.size();i++)
            search(i,0,commons,longer,0,shorter,0);

        return max_len;
    }

    public void search(int pos,int len,List<Character> commons,String longer,int longer_pt,String shorter,int shorter_pt){
        //System.out.println("pos"+pos);
        if(len+(commons.size()-pos-1)<max_len)
            return;
        //System.out.println("pos"+pos);
        char current = commons.get(pos);
        //System.out.println("##: "+current+" pos: "+pos);
        boolean longer_found = false;
        boolean shorter_found = false;
        int i = longer_pt;
        int j = shorter_pt;

        for(;i<longer.length();i++){
            if(longer.charAt(i)==current){
                longer_found = true;
                break;
            }
        }
        for(;j<shorter.length();j++){
            if(shorter.charAt(j)==current){
                shorter_found = true;
                break;
            }
        }
        if(longer_found&&shorter_found){
            len++;
            max_len = Math.max(len,max_len);
            for(int m = pos+1;m<commons.size();m++){
                search(m,len,commons,longer,i+1,shorter,j+1);
            }
        }
    }


}
