package com.pleasecode.leetcode.solutions;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean match = dfs(board, i - 1, j, visited, word, index + 1) ||
                dfs(board, i + 1, j, visited, word, index + 1) ||
                dfs(board, i, j - 1, visited, word, index + 1) ||
                dfs(board, i, j + 1, visited, word, index + 1);
        visited[i][j] = false;
        return match;
    }
}
