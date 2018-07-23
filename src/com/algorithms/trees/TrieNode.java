package com.algorithms.trees;

public class TrieNode {

    public TrieNode[] children;
    public boolean isWord;

    public TrieNode(){

        this.children = new TrieNode[26];
        this.isWord = false;
    }
}
