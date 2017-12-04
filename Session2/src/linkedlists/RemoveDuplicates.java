package linkedlists;

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode a) {
        ListNode current = a;
        while(current != null){
            ListNode runner = current;

            while(runner.next != null){
                if(runner.next.val == current.val){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        return a;
    }
}
