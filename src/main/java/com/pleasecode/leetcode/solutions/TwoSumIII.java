package com.pleasecode.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */
public class TwoSumIII {

    Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        int count = map.get(number) == null ? 0 : map.get(number);
        map.put(number, count + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int y = value - x;
            if (x == y) {
                if (entry.getValue() > 1) {
                    return true;
                }
            } else if (map.containsKey(y)) {
                return true;
            }
        }
        return false;
    }
}
