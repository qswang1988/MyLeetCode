package data_structure.Min_Stack_155;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/min-stack/
// EASY
public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(-1);
        minStack.push(5);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}


class MinStack {

    LinkedList<Integer> list;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        list = new LinkedList<>();
    }

    public void push(int val) {
        list.add(val);
        if(min!=Integer.MAX_VALUE)
            min = Integer.min(val,min);
    }

    public void pop() {
        if(min==list.getLast())
            min = Integer.MAX_VALUE;
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        if(min!=Integer.MAX_VALUE)
            return min;
        for(int i:list)
            min = Integer.min(min,i);
        return min;
    }

}
