package com.my.datastrcture.codingninja.tries;

public class TrieNode {
    int childCount;
    char data;
    boolean isTerminal;
    TrieNode children[];

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }
}
