package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return triplets;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i = increase(nums, i)) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j = increase(nums, j);
                    k = decrease(nums, k);
                } else if (sum < 0) {
                    j = increase(nums, j);
                } else {
                    k = decrease(nums, k);
                }
            }
        }
        return triplets;
    }

    private int increase(int[] nums, int j) {
        while (j < nums.length - 1 && nums[j] == nums[++j]) {}
        return j;
    }

    private int decrease(int[] nums, int k) {
        while (k > 0 && nums[k] == nums[--k]) {}
        return k;
    }
}
