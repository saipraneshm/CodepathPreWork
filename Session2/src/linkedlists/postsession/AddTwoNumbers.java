package linkedlists.postsession;

import linkedlists.ListNode;

/**
 * Created by saip92 on 12/8/2017.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode first = a;
        ListNode second = b;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carryOn = 0;
        while(first != null || second != null){
            int  totalSum = 0;

            totalSum += carryOn;

            if(first != null){
                totalSum += first.val;
                first = first.next;
            }

            if(second != null){
                totalSum += second.val;
                second = second.next;
            }

            int digitVal = totalSum % 10;

            carryOn = totalSum > 9 ? 1 : 0;

            result.next = new ListNode(digitVal);

            result = result.next;
        }

        if(carryOn > 0){
            result.next = new ListNode(carryOn);
        }

        return dummy.next;
    }
}
