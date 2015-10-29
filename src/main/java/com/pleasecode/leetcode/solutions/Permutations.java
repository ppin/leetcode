package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        helper(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void helper(int[] nums, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            helper(nums, permutation, permutations);
            permutation.remove(permutation.size() - 1);
        }
    }
}
