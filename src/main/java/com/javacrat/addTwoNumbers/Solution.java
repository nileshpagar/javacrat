package com.javacrat.addTwoNumbers;


import java.util.List;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);


//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        solution.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode answerIterator = answer;
        int carryForward = 0;
        while(l1 !=null || l2 !=null) {
            int addition = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + carryForward;
            answerIterator.val = addition%10;
            carryForward = addition/10;
            l1 = (l1!=null) ? l1.next : l1;
            l2 = (l2!=null) ? l2.next : l2;
            if (l1 !=null || l2 !=null) {
                answerIterator.next = new ListNode();
                answerIterator = answerIterator.next;
            }
        }
        if(carryForward != 0) answerIterator.next = new ListNode(carryForward);
        return answer;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}