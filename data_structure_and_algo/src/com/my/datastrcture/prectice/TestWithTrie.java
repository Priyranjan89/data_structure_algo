package com.my.datastrcture.prectice;

import java.util.ArrayList;

public class TestWithTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        ArrayList<String> words = new ArrayList<>();
        //abc def ghi cba
        words.add("abc");
        words.add("def");
        words.add("ghi");
        words.add("cba");
        System.out.println(trie.isPalindromePair(words));;
    }
}
