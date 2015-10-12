package com.pleasecode.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode cur = root;
        TrieNode node;
        for (int i = 0; i < word.length(); i++) {
            node = cur.children.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode(word.charAt(i), i == word.length() - 1);
            } else {
                if (i == word.length() - 1) {
                    node.endOfWord = true;
                }
            }
            cur.children.put(word.charAt(i), node);
            cur = node;
        }
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode cur = root;
        TrieNode node;
        for (int i = 0; i < word.length(); i++) {
            node = cur.children.get(word.charAt(i));
            if (node == null) {
                return false;
            }
            if (!node.endOfWord && i == word.length() - 1) {
                return false;
            }
            cur = node;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        TrieNode cur = root;
        TrieNode node;
        for (int i = 0; i < prefix.length(); i++) {
            node = cur.children.get(prefix.charAt(i));
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return true;
    }

    class TrieNode {
        char value;
        boolean endOfWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this(' ');
        }

        public TrieNode(char value) {
            this(value, false);
        }

        public TrieNode(char value, boolean endOfWord) {
            this.value = value;
            this.endOfWord = endOfWord;
            children = new HashMap<>(26);
        }
    }
}
