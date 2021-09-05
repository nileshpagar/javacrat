package com.javacrat.linkedlist;

import java.util.Stack;

//Definition for singly-linked list.
public class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        Stack stack = new Stack();
        Node current = this;
        StringBuffer buffer = new StringBuffer();
        while (current != null) {
            buffer.append(current.val);
            if (current.next != null)
                buffer.append(" ---> ");
            current = current.next;
        }
        return buffer.toString();
    }
}
