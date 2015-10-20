package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s.length());
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (builder.length() != 0) {
                    builder.append(" ");
                }
                builder.append(s.substring(i, j));
            }
        }
        return builder.toString();
    }
}
