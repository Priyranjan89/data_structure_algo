package com.my.datastrcture.prectice.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Node class to represent each node in the Huffman Tree
class Node {
    char character;
    int frequency;
    Node left, right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    public Node(int frequency, Node left, Node right) {
        this.character = '\0'; // '\0' is a placeholder for non-leaf nodes
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

// Main HuffmanCoding class
public class HuffmanCoding {
    private final Map<Character, String> huffmanCodes = new HashMap<>();
    private Node root;

    // Method to build the Huffman Tree
    public void buildHuffmanTree(String text) {
        // Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Priority queue to hold the nodes
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        // Create leaf nodes for each character and add to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.frequency + right.frequency;
            pq.add(new Node(sum, left, right));
        }

        // The root of the tree
        root = pq.poll();

        // Generate Huffman codes from the tree
        generateCodes(root, "");
    }

    // Helper method to generate Huffman codes by traversing the tree
    private void generateCodes(Node node, String code) {
        if (node == null) {
            return;
        }

        // If it's a leaf node, it contains a character
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    // Method to encode a given text using the generated Huffman codes
    public String encode(String text) {
        StringBuilder encodedString = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedString.append(huffmanCodes.get(ch));
        }
        return encodedString.toString();
    }

    // Method to decode an encoded string using the Huffman Tree
    public String decode(String encodedText) {
        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            // If it's a leaf node, we found a character
            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.character);
                currentNode = root; // Start again from the root for the next character
            }
        }
        return decodedString.toString();
    }

    // Method to get the Huffman codes for each character
    public Map<Character, String> getHuffmanCodes() {
        return huffmanCodes;
    }

    // Main method for testing the Huffman Coding
    public static void main(String[] args) {
        String text = "huffman coding example";

        HuffmanCoding huffmanCoding = new HuffmanCoding();
        huffmanCoding.buildHuffmanTree(text);

        // Print the Huffman codes for each character
        System.out.println("Huffman Codes: " + huffmanCoding.getHuffmanCodes());

        // Encode the text
        String encodedText = huffmanCoding.encode(text);
        System.out.println("Encoded Text: " + encodedText);

        // Decode the text
        String decodedText = huffmanCoding.decode(encodedText);
        System.out.println("Decoded Text: " + decodedText);
    }
}

