package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length()) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
