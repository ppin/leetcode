package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int cur = 0;
        int red = 0;
        int blue = nums.length - 1;
        while (cur <= blue) {
            if (nums[cur] == 0) {
                swap(nums, cur++, red++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, blue--);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
