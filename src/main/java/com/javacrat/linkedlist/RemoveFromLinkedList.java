package com.javacrat.linkedlist;


public class RemoveFromLinkedList {

    public static void main(String[] args) {
        RemoveFromLinkedList removeFromLinkedList = new RemoveFromLinkedList();
        Node linkedList = new Node(1, new Node(2, new Node(6, new Node(3, new Node(4, new Node(5, new Node(6)))))));
        System.out.println(linkedList);
        System.out.println(removeFromLinkedList.removeElements(linkedList, 7));
        linkedList = new Node(7, new Node(7, new Node(7, new Node(7, new Node(7)))));
        System.out.println(linkedList);
        System.out.println(removeFromLinkedList.removeElements(linkedList, 7));
    }

    public Node removeElements(Node head, int val) {

        if(head == null) return head;

        Node sub = removeElements(head.next , val);

        head.next = sub;
        return head.val == val ? sub : head;

    }
}
