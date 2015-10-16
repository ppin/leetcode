package com.pleasecode.leetcode.solutions;

import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
