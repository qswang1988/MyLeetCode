package data_structure.MergeKSortedLists_23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();
        ListNode node8 = new ListNode();
        node1.val = 1;
        node2.val = 4;
        node3.val = 5;
        node4.val = 1;
        node5.val = 3;
        node6.val = 4;
        node7.val = 2;
        node8.val = 6;

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;

        ListNode [] lists = {node1,node4,node7};

        System.out.println(lists[0].val);
        System.out.println(lists[1].val);
        System.out.println(lists[2].val);
        System.out.println("##########");
        ListNode r = new Solution().mergeKLists(lists);
        while(r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        ListNode currNode = null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (ListNode node:lists) {
            if(node!=null)
                queue.add(node);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(currNode==null)
                listNode = node;
            else
                currNode.next = node;

            currNode = node;
            if(node.next!=null)
                queue.add(node.next);
        }


        return listNode;
    }
}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
