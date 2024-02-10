package divide_and_conquer.Different_Ways_to_Add_Parentheses_241;

/*
*   https://leetcode.com/problems/different-ways-to-add-parentheses/
*   MEDIUM
*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String exp = "2*3-4*5";
        List<Integer> r = new Solution().diffWaysToCompute(exp);
        //String [] s = split_by(exp,3);
        //System.out.println(s[0]+","+s[1]);
        System.out.println(r);
    }

    // the map mainly reduce memory consumption
    public Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> numbers = new ArrayList<>();
        if(expression.length()<3) {
            numbers.add(Integer.valueOf(expression));
            return numbers;
        }

        char [] exp = expression.toCharArray();

        if(map.containsKey(expression))
            return map.get(expression);

        for(int i = 0;i<exp.length;i++){
            if(exp [i] == '+' || exp [i] == '-' || exp [i] == '*'){
                List<Integer> leftSide = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightSide = diffWaysToCompute(expression.substring(i+1));

                //System.out.println("left: "+leftSide);
                //System.out.println("right: "+rightSide);

                for(int l:leftSide){
                    for(int r:rightSide){
                        int p = 0;
                        if(exp [i] == '+')
                            p = l + r;
                        else if(exp [i] == '-')
                            p = l - r;
                        else
                            p = l * r;
                        numbers.add(p);
                        map.put(expression,numbers);
                    }
                }
            }
        }

        /*if(numbers.isEmpty()) {
            numbers.add(Integer.valueOf(exp[0]-'0'));
            System.out.println(Integer.valueOf(exp[0]-'0')+"#");
        }*/
        return numbers;
    }

}


