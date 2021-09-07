package Math.Linked_List_Random_Node_382;

import java.util.List;
import java.util.Random;

/*
*   https://leetcode.com/problems/linked-list-random-node/
*   MEDIUM
* */
public class Solution {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode last = ln1;
        for(int i = 2;i<11;i++){
            ListNode ln = new ListNode(i);
            last.next = ln;
            last = ln;
        }

        Solution sl = new Solution(ln1);

        for(int i = 0;i<=50;i++){
            System.out.println(sl.getRandom());
        }


    }

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        size = getSize(head);
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int num = new Random().nextInt(size)+1;
        int count = 1;
        ListNode ln = head;
        while(count<num){
            ln = ln.next;
            count++;
        }
        return ln.val;
    }

    int size;
    public int getSize(ListNode head){
        int count = 1;
        ListNode n = head;
        while(n!=null){
            n = n.next;
            count++;
        }
        return count-1;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
