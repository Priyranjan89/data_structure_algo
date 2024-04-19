package com.my.datastrcture.codingninja.tries;

import java.util.ArrayList;

public class Trie {
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void add(String word) {
        if (addHelper(root, word)) {
            numWords++;
        }
    }

    private boolean addHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal) {
                return false;
            } else {
                root.isTerminal = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return addHelper(child, word.substring(1));
    }

    private boolean searchHelper(TrieNode root, String word) {

        if (word.length() == 0) {
            return root.isTerminal;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }
        return searchHelper(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    public void remove(String word) {
        if (removeHelper(root, word)) {
            numWords--;
        }
    }

    public boolean removeHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal) {
                root.isTerminal = false;
                return true;
            } else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        boolean ans = false;

        if (child == null) {
            return ans;
        }
        ans = removeHelper(child, word.substring(1));
        if (!child.isTerminal && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
        return ans;
    }

    public int countWords() {
        return numWords;
    }

    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for (int i = 0; i < vect.size(); i++) {
            String word = vect.get(i);
            for (int j = 0; j < word.length(); j++) {
                add(word.substring(j));
            }
        }
        return searchHelper(root, pattern);
    }

    public boolean isPalindromePair(ArrayList<String> words) {

        for (int i = 0; i < words.size(); i++) {
            String reverseWord = reverse(words.get(i));
            addHelper(root, reverseWord);
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

    private boolean isPalindromePair(TrieNode root, ArrayList<String> words){
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

    private boolean doesPairExistFor(TrieNode root, String word, int startIndex){
        if (word.length() == 0){
            return true;
        }
        if (startIndex == word.length()){
            if (root.isTerminal){
                return true;
            }
            return checkRemainingBranchesInTrie(root, "");
        }
        int charIndex = word.charAt(startIndex) - 'a';
        TrieNode child = root.children[charIndex];
        if (child == null){
            if (root.isTerminal){
                return checkWordForPalindrome(word.substring(startIndex));
            } else {
                return false;
            }
        }
        return doesPairExistFor(child, word, startIndex+1);
    }

    private boolean checkRemainingBranchesInTrie(TrieNode root, String word){
        if (root.isTerminal){
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

    private boolean checkWordForPalindrome(String word){
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

    public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
        int i=0;
        while(i<input.size()){
            String a=input.get(i);
            addHelper(root,a);
            i++;
        }
        if(root == null || root.childCount == 0) {
            return;
        }
        TrieNode a=findword(root,word);
        String output = "";
        allwords(a,word,output);

    }
    public void allwords(TrieNode root,String word,String output){
        if(root == null){
            return;
        }

        if(root!=null && root.childCount == 0) {
            if(output.length() > 0) {
                System.out.println(word + output);
            }
            return;
        }
        if(root!=null && root.isTerminal == true) {
            System.out.println(word + output);
        }

        for(int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                String ans = output + root.children[i].data;
                allwords(root.children[i],word,ans);
            }
        }
    }
    public TrieNode findword(TrieNode root, String word) {
        if(word.length() == 0){
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return null;
        }
        return findword(child, word.substring(1));
    }
}
