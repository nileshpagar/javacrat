package com.javacrat.linkedlist;


import java.util.Stack;

public class RemoveFromLinkedList {

     //Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         public ListNode() {}
         public ListNode(int val) { this.val = val; }
         public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             Stack stack = new Stack();
             RemoveFromLinkedList.
             ListNode current = this;
             StringBuffer buffer = new StringBuffer();
             while (current !=null) {
                 buffer.append(current.val);
                 if (current.next != null)
                    buffer.append(" ---> ");
                 current = current.next;
             }
             return buffer.toString();
         }
     }

    public static void main(String[] args) {
        RemoveFromLinkedList removeFromLinkedList = new RemoveFromLinkedList();
        ListNode linkedList = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println(linkedList);
        System.out.println(removeFromLinkedList.removeElements(linkedList, 7));
        linkedList = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))));
        System.out.println(linkedList);
        System.out.println(removeFromLinkedList.removeElements(linkedList, 7));
    }

    public ListNode removeElements(ListNode head, int val) {

        if(head == null) return head;

        ListNode sub = removeElements(head.next , val);

        head.next = sub;
        return head.val == val ? sub : head;

    }
}
