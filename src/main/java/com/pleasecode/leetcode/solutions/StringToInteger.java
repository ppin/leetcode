package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        int i = 0, len = str.length();
        int sign = 1;
        while (i < len && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        if (i < len && str.charAt(i) == '+') {
            i++;
        } else if (i < len && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        int threshold = Integer.MAX_VALUE / 10;
        while (i < len && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > threshold || (num == threshold && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}
