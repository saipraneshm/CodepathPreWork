package binarysearch.postsession;

import binarysearch.ListNode;

import java.util.ArrayList;

/**
 * Created by saip92 on 12/16/2017.
 */
public class MergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        return mergeSort(a,0,a.size()-1);
    }

    public ListNode mergeSort(ArrayList<ListNode> a, int left, int right){
        if(left == right) return a.get(left);
        if(left < right){
            int mid = (left + right)/2;
            ListNode l1 = mergeSort(a, left, mid);
            ListNode l2 = mergeSort(a, mid+1, right);
            return merge2Lists(l1, l2);
        }else{
            return null;
        }
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode point = head;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                point.next = l1;
                l1 = l1.next;
            }else{
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }

        if(l1 != null){
            point.next = l1;
        }else{
            point.next = l2;
        }

        return head.next;
    }

}
