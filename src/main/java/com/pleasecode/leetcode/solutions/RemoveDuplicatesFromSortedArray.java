package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        if (nums == null || nums.length == 0) {
            return index;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                continue;
            }
            nums[++index] = nums[i];
        }
        return index + 1;
    }
}
