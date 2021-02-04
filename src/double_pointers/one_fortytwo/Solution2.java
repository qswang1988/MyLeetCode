package double_pointers.one_fortytwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    // two pointers, one go slow, one go faster.
    // if two pointers meet eventually, it is a cycle

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        int pos = 0;
        while(true){

            if(fast==null||fast.next==null)
                return null;

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                fast = head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        //return null;
    }
}