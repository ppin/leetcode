package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        for (int i = index; i< nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
