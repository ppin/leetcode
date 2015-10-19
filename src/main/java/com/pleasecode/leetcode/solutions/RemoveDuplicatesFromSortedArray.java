package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index - 1] == nums[i]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
