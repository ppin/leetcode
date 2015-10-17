package com.pleasecode.leetcode.solutions;

import com.pleasecode.leetcode.solutions.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
