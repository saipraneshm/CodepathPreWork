package linkedlists;

/**
 * Created by saip92 on 12/4/2017.
 */
public class ReverseKLinkedLists {
    public ListNode reverseList(ListNode A, int B) {
        int length = getListLength(A);
        if(A == null || B <= 1 || length % B != 0) return A;
        return reverseHelper(A,B);
    }

    public ListNode reverseHelper(ListNode A, int B){
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        while(count < B && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null) A.next = reverseHelper(next,B);

        return prev;
    }

    public int getListLength(ListNode A){
        int count = 0;
        ListNode current = A;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
}
