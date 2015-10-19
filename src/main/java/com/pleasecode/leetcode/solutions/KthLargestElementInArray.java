package com.pleasecode.leetcode.solutions;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            throw new IllegalArgumentException("Illegal arguments");
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (minHeap.peek() < num) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }
}
