package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                }
            }
        }
        if (!f[s.length()]) {
            return result;
        }
        dfs(s, wordDict, f, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String s, Set<String> wordDict, boolean[] f, int index, StringBuilder builder, List<String> result) {
        if (index == s.length()) {
            result.add(builder.toString());
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (!f[index]) {
                continue;
            }
            String word = s.substring(index, i);
            if (!wordDict.contains(word)) {
                continue;
            }
            int len = builder.length();
            if (len != 0) {
                builder.append(" ");
            }
            builder.append(word);
            dfs(s, wordDict, f, i, builder, result);
            builder.delete(len, builder.length());
        }
    }
}
