package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int num = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        int threshold = Integer.MAX_VALUE / 10;
        while (x > 0) {
            int digit = x % 10;
            if (num > threshold || (num == threshold && digit > 7)) {
                return 0;
            }
            num = num * 10 + digit;
            x = x / 10;
        }
        return num * sign;
    }
}
