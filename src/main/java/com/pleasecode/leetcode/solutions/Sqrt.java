package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int start = 1;
        int end = x / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
