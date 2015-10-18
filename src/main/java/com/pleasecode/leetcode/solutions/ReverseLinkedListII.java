package com.pleasecode.leetcode.solutions;

import com.pleasecode.leetcode.solutions.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode tmpHead = dummy;
        int pos = 1;
        while (pos < m && tmpHead != null) {
            tmpHead = tmpHead.next;
            pos++;
        }

        if (tmpHead == null || tmpHead.next == null) {
            return dummy.next;
        }

        ListNode prev = tmpHead.next;
        ListNode cur = prev.next;
        while (pos < n && cur != null) {
            prev.next = cur.next;
            cur.next = tmpHead.next;
            tmpHead.next = cur;
            cur = prev.next;
            pos++;
        }

        return dummy.next;
    }
}
