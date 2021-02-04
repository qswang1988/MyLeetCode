package double_pointers.one_fortytwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //Map<Integer,ListNode> map = new HashMap<>();
        // hashset use HashMap to implement interface set.., duplicated elements are now allowed
        Set set = new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }