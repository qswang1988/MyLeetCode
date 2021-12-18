package data_structure.Implement_Queue_using_Stacks_232;

import java.util.Stack;

/*
    https://leetcode.com/problems/implement-queue-using-stacks/
* */
public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);

        while(!myQueue.empty()){
            //System.out.println("x");
            System.out.println(myQueue.pop());
        }

    }

}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(x);
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack2.push(x);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.isEmpty()?stack2.pop():stack1.pop();
    }

    public int peek() {
        return stack1.isEmpty()?stack2.peek():stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}

