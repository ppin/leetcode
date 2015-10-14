package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i = increase(nums, i)) {
            for (int j = i + 1; j < nums.length - 2; j = increase(nums, j)) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k = increase(nums, k);
                        l = decrease(nums, l);
                    } else if (sum < target) {
                        k = increase(nums, k);
                    } else {
                        l = decrease(nums, l);
                    }
                }
            }
        }
        return quadruplets;
    }

    private int increase(int[] nums, int low) {
        do {
            low++;
        } while(low < nums.length && nums[low] == nums[low - 1]);
        return low;
    }

    private int decrease(int[] nums, int high) {
        do {
            high--;
        } while(high >= 0 && nums[high] == nums[high + 1]);
        return high;
    }
}
