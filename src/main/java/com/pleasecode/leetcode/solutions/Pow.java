package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / pow(x, -n) : pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = pow(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }
}
