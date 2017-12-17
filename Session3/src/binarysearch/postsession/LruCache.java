package binarysearch.postsession;

import java.util.HashMap;

/**
 * Created by saip92 on 12/16/2017.
 */
public class LruCache {

    private static class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }

        public String toString(){
            return  " " + val;
        }

    }

    private int capacity;
    private HashMap<Integer, ListNode> map = new HashMap<>();
    private ListNode head = null;
    private ListNode tail = null;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public void insertAtFrontOfList(ListNode node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void removeFromList(ListNode node){
        if(node == null) return;

        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        if(node == tail) tail = node.prev;
        if(node == head) head = node.next;
    }

    public boolean removeKey(int key){
        ListNode item = map.get(key);
        removeFromList(item);
        map.remove(key);
        return true;
    }

    public int get(int key) {
        ListNode item = map.get(key);

        if(item == null) return -1;

        if(item != head){
            removeFromList(item);
            insertAtFrontOfList(item);
        }


        return item.val;
    }

    public void set(int key, int value) {
        removeKey(key);

        if(map.size() >= capacity && tail != null){
            removeKey(tail.key);
        }

        ListNode newNode = new ListNode(key,value);
        insertAtFrontOfList(newNode);
        map.put(key,newNode);

    }

}
