package com.pleasecode.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Illegal number array.");
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i = increase(nums, i)) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j = increase(nums, j);
                } else {
                    k = decrease(nums, k);
                }
                if (Math.abs(target - closestSum) > Math.abs(target - sum)) {
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }

    private int increase(int[] nums, int low) {
        do {
            low++;
        } while (low < nums.length && nums[low] == nums[low - 1]);
        return low;
    }

    private int decrease(int[] nums, int high) {
        do {
            high--;
        } while(high >= 0 && nums[high] == nums[high + 1]);
        return high;
    }
}
