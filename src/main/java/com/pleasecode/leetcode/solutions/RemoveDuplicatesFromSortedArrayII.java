package com.pleasecode.leetcode.solutions;

/**
 * Created by gabriel on 20/10/15.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] == nums[i]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
