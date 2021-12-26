package data_structure.daily_temperatures_739;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
*   https://leetcode.com/problems/daily-temperatures/
*   Medium
* */
public class Solution {
    public static void main(String[] args) {
        int [] temperatures = {73,74,75,71,69,72,76,73};
        int [] r = new Solution().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(r));
    }

    // monotonic stack
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int [] r = new int [temperatures.length];
        // we put index in stack , by comparing elements in array
        for(int i = 0;i<temperatures.length;i++){
            while(stack.size()>0&&temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                r [index] = i - index;
            }
            stack.push(i);

        }
        return r;
    }
}
