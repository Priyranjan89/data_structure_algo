package com.my.datastrcture.codingninja.tries;

import java.util.ArrayList;

public class TrieUse {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("ABC");
        trie.add("MCBA");
//2
//abc mcba
        ArrayList<String> words = new ArrayList<>();
        words.add("ABC");
        words.add("MCBA");
        System.out.println(trie.isPalindromePair(words));
    }
}
