package com.my.datastrcture.prectice;

import java.util.ArrayList;

class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}


public class Trie {

    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length() == 0) {
            return root.isTerminating;
        }

        int childIndex=word.charAt(0) - 'a';
        TrieNode child=root.children[childIndex];

        if(child == null) {
            return false;
        }

        return search(child,word.substring(1));

    }

    public boolean search(String word) {
        return search(root,word);
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            System.out.println(word);
        }

        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }





    /*..................... Palindrome Pair................... */


    public boolean isPalindromePair(ArrayList<String> words) {

        for (int i = 0; i < words.size(); i++) {
            String reverseWord = reverse(words.get(i));
            add(root, reverseWord);
        }

        return isPalindromePair(root, words);
    }
    private String reverse(String i){
        String newstr = "";
        while (i.length() != 0){
            newstr = i.charAt(0) + newstr;
            i = i.substring(1);
        }
        return newstr;
    }

    public boolean isPalindromePair(TrieNode root, ArrayList<String> words){
        if (words.isEmpty()){
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (doesPairExistFor(root, words.get(i), 0)){
                return true;
            }
        }
        return false;
    }

    public boolean doesPairExistFor(TrieNode root, String word, int startIndex){
        if (word.length() == 0){
            return true;
        }
        if (startIndex == word.length()){
            if (root.isTerminating){
                return true;
            }
            return checkRemainingBranchesInTrie(root, "");
        }
        int charIndex = word.charAt(startIndex) - 'a';
        TrieNode child = root.children[charIndex];
        if (child == null){
            if (root.isTerminating){
                return checkWordForPalindrome(word.substring(startIndex));
            } else {
                return false;
            }
        }
        return doesPairExistFor(child, word, startIndex+1);
    }

    public boolean checkRemainingBranchesInTrie(TrieNode root, String word){
        if (root.isTerminating){
            if (checkWordForPalindrome(word)){
                return true;
            }
        }

        for (int i =0; i <= 25; i++){
            TrieNode childNode = root.children[i];
            if (childNode == null){
                continue;
            }
            String fwd = "";
            fwd = fwd+childNode.data;
            if (checkRemainingBranchesInTrie(childNode, fwd)){
                return true;
            }
        }
        return false;
    }

    public boolean checkWordForPalindrome(String word){
        int startIndex = 0;
        int endIndex = word.length()-1;
        while (startIndex < endIndex){
            if (word.charAt(startIndex) != word.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
