package com.javacrat.linkedlist;

public class ReverseLinkedList {

    public static Node reverseRecursively(Node head) {
        if (head == null || head.next == null) return head;
        Node newHeadNode = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }

    public static Node reverseIteratively(Node head) {
        Node reversedHead = null;
        while(head != null) {
            reversedHead = new Node(head.val, reversedHead);
            head = head.next;
        }
        return reversedHead;
    }

    public static void main(String[] args) {
        Node linkedList = new Node(5, new Node(4, new Node(3, new Node(2, new Node(1)))));
        System.out.println("created linked list");
        System.out.println(linkedList);
        linkedList = reverseIteratively(linkedList);
        System.out.println("reversing using iterative approach");
        System.out.println(linkedList);
        linkedList = reverseRecursively(linkedList);
        System.out.println("reversing using recursive approach");
        System.out.println(linkedList);
    }

}
