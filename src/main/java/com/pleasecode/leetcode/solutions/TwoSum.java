package com.pleasecode.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        if (nums == null || nums.length < 2) {
            return indices;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                indices[0] = map.get(nums[i]) + 1;
                indices[1] = i + 1;
            }
        }
        return indices;
    }
}
