package com.my.datastrcture.prectice.tries;

import java.util.ArrayList;

public class TriesUse {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.add("NOTE");
        trie.add("ADD");

        System.out.println(trie.search("NOTE"));
        trie.remove("NOTE");
        System.out.println(trie.search("NOTE"));
    }
}
