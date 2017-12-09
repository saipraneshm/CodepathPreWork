package linkedlists.postsession;


import linkedlists.ListNode;

public class DetectCycle {


    public ListNode detectCycle(ListNode a) {

        ListNode slow = a;
        ListNode fast = a;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null) return null;

        slow = a;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

    }

}
