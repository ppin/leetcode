package com.pleasecode.leetcode.solutions;

import com.pleasecode.leetcode.solutions.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = prev.next;

        int pos = 1;
        while (cur != null) {
            if (pos == k) {
                pos = 0;
                prev = reverse(prev, cur);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
            pos++;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode cur = prev.next;
        while (prev.next != end) {
            ListNode nnext = cur.next.next;
            cur.next.next = prev.next;
            prev.next = cur.next;
            cur.next = nnext;
        }
        return cur;
    }
}
