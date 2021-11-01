package Math.Excel_Sheet_Column_Title_168;

/*
*   https://leetcode.com/problems/excel-sheet-column-title/
*   Easy
*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String r = new Solution().convertToTitle(Integer.MAX_VALUE-1);
        System.out.println(r);

    }


    public String convertToTitle(int columnNumber) {
        char [] letters = {'/','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        List<Character> list = new ArrayList<>();
        int c = columnNumber;
        while(c>26){
            int r = c%26;
            if(r!=0) {
                list.add(letters[r]);
                c = (c - r) / 26;
            }else{
                list.add(letters[26]);
                c = c/26-1;
            }
        }
        if(c!=0)
            list.add(letters [c]);
        //System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1;i>=0;i--)
            sb.append(list.get(i));
        return sb.toString();
    }

}
