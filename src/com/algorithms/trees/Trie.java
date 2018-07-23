package com.algorithms.trees;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {

        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        int n = word.length();
        TrieNode node = this.root;

        for (int i=0; i<n; i++){

            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){

                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = this.isValidPath(word);

        if (node == null){
            return false;
        }

        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return this.isValidPath(prefix) != null;
    }

    private TrieNode isValidPath(String word){
        TrieNode node = this.root;
        int n = word.length();

        for (int i=0; i<n; i++){

            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){

                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}
