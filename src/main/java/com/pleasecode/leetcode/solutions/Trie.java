package com.pleasecode.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<String> suggest(String prefix) {
        List<String> result = new ArrayList<>();
        if (prefix == null || prefix.isEmpty()) {
            return result;
        }
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            cur = cur.children.get(prefix.charAt(i));
            if (cur == null) {
                return result;
            }
        }
        StringBuilder builder = new StringBuilder(prefix);
        helper(cur, builder, result);
        return result;
    }

    private void helper(TrieNode cur, StringBuilder builder, List<String> result) {
        if (cur == null) {
            return;
        }
        if (cur.endOfWord) {
            result.add(builder.toString());
        }
        for (char c : cur.children.keySet()) {
            TrieNode node = cur.children.get(c);
            builder.append(c);
            helper(node, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
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

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apart");
        trie.insert("application");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.suggest("app"));
    }
}
