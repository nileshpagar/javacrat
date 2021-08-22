package com.javacrat.linkedlist;

public class DoublyLinkedList {
    Node head;

    private static class Node {
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /** Initialize your data structure here. */
    public DoublyLinkedList() {
        head= null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node nodeAt = getNode(index);
        return (nodeAt == null) ? -1 : nodeAt.value;
    }

    public Node getNode(int index) {
        Node current=head;
        for(int i=0; (current!=null && i<index); i++, current=current.next) ;
        return current;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val, head);
        head.previous = newHead;
        head = newHead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node current = head;
        Node previous = null;
        while(current != null) {
            previous = current;
            current = current.next;
        }
        if(previous != null) {
            Node tail = new Node(val);
            previous.next = tail;
            tail.previous = previous;
        } else {
            head = new Node(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            Node newHead = new Node(val, this.head);
            this.head.previous = newHead;
            head = newHead;

        } else {
            Node previous = getNode(index-1);
            if (previous != null)
                previous.next = new Node(val, previous.next);
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0) {
            head = head.next;
        } else {
            Node previous = getNode(index-1);
            if (previous != null && previous.next != null) {
                previous.next = previous.next.next;
            }

        }
    }

}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
