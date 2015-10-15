package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchII {

    private TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word, word);
        }
        Set<String> existedWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root.children.get(board[i][j]), visited, existedWords);
            }
        }
        return new ArrayList<>(existedWords);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, Set<String> existedWords) {
        if (node == null) {
            return;
        }
        if (node.value != null && !existedWords.contains(node.value)) {
            existedWords.add(node.value);
        }
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j]) {
            dfs(board, i - 1, j, node.children.get(board[i - 1][j]), visited, existedWords);
        }
        if (i < board.length - 1 && !visited[i + 1][j]) {
            dfs(board, i + 1, j, node.children.get(board[i + 1][j]), visited, existedWords);
        }
        if (j > 0 && !visited[i][j - 1]) {
            dfs(board, i, j - 1, node.children.get(board[i][j - 1]), visited, existedWords);
        }
        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            dfs(board, i, j + 1, node.children.get(board[i][j + 1]), visited, existedWords);
        }
        visited[i][j] = false;
    }

    private void insert(String word, String value) {
        TrieNode cur = root;
        TrieNode node;
        for (int i = 0; i < word.length(); i++) {
            node = cur.children.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                cur.children.put(word.charAt(i), node);
            }
            cur = node;
        }
        cur.value = value;
    }

    class TrieNode {
        String value;
        Map<Character, TrieNode> children = new HashMap<>(26);
    }
}
