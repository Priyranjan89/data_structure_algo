package com.my.datastrcture.prectice.tries;

import java.util.ArrayList;

public class Tries {
    private TrieNode root;
    private int numWords;

    public Tries(){
        root = new TrieNode('\0');
        numWords = 0;
    }

    public void add(String word){
        addHelper(root, word);
        numWords++;
    }

    private void addHelper(TrieNode root, String word){

        if (word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        addHelper(child, word.substring(1));
    }

    public boolean search(String word){
        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal == true)
                return true;
            else
                return false;
        }
        boolean ans = false;
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child != null)
            ans = searchHelper(child, word.substring(1));
        return ans;
    }

    public void remove(String word){
        removeHelper(root, word);
        numWords--;
    }

    private void removeHelper(TrieNode root, String word){
        if (word.length() == 0){
            root.isTerminal = false;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null){
            return;
        }
        removeHelper(child, word.substring(1));
        if (child.isTerminal && child.childCount == 0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public int countWords() {
        return numWords;
    }


    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for (int i = 0; i < vect.size(); i++){
            String word = vect.get(i);
            for (int j = 0; j < word.length(); j++){
                add(word.substring(j));
            }
        }
        return searchHelper(root, pattern);
    }

/*Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome or not.



Note: The function should return either true or false. You don't have to print anything.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome
Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.'*/
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check if any palindrome pair exists
    public boolean isPalindromePair(ArrayList<String> words) {
        // Step 1: Add all reversed words to the Trie
        for (String word : words) {
            add(new StringBuilder(word).reverse().toString());
        }

        // Step 2: Check each word for palindrome pair condition
        for (String word : words) {
            int len = word.length();

            // Check if the word itself is a palindrome and exists in the Trie
            if (isPalindrome(word)) {
                return true;
            }

            // Check for each possible split in the word
            for (int i = 0; i <= len; i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);

                // Case 1: If the prefix is a palindrome and reverse of suffix exists in the Trie
                if (isPalindrome(prefix) && search(suffix)) {
                    return true;
                }

                // Case 2: If the suffix is a palindrome and reverse of prefix exists in the Trie
                if (isPalindrome(suffix) && search(prefix)) {
                    return true;
                }
            }
        }

        return false;
    }

    /*Problem statement
Given n number of words and an incomplete word w. You need to auto-complete that word w.

That means, find and print all the possible words which can be formed using the incomplete word w.

Note : Order of words does not matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 1 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"*/


    public void autoComplete(ArrayList<String> input, String word) {
        // Step 1: Add all words to the Trie
        for (String w : input) {
            add(w);
        }

        // Step 2: Find the node corresponding to the last character of the prefix
        TrieNode prefixNode = findNode(word);

        if (prefixNode == null) {
            System.out.println("(Empty) There is no word which starts with \"" + word + "\"");
            return;
        }

        // Step 3: Collect all words that start with this prefix
        ArrayList<String> result = new ArrayList<>();
        findWords(prefixNode, word, result);

        // Print the results
        if (result.isEmpty()) {
            System.out.println("(Empty) There is no word which starts with \"" + word + "\"");
        } else {
            for (String w : result) {
                System.out.println(w);
            }
        }
    }

    private TrieNode findNode(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int childIndex = prefix.charAt(i) - 'a';
            TrieNode child = currentNode.children[childIndex];
            if (child == null) {
                return null;  // If prefix does not exist, return null
            }
            currentNode = child;
        }
        return currentNode;
    }

    private void findWords(TrieNode node, String prefix, ArrayList<String> result) {
        if (node.isTerminal) {
            result.add(prefix); // If it's a terminating node, add the word
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                findWords(node.children[i], prefix + node.children[i].data, result);
            }
        }
    }
}
