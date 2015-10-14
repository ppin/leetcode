package com.pleasecode.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 */
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) {
            return count;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
