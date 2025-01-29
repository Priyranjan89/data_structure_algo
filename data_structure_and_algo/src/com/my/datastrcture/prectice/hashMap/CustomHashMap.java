package com.my.datastrcture.prectice.hashMap;

// Custom HashMap class using a self-balancing AVL tree with natural key sorting
public class CustomHashMap<K extends Comparable<K>, V> {
    private class TreeNode {
        K key;
        V value;
        TreeNode left, right;
        int height;

        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1; // New node is initially added at the leaf, height is 1
        }
    }

    private TreeNode root;

    // Get the height of the node
    private int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    // Right rotate subtree rooted with node
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with node
    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node
    private int getBalance(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Insert a key-value pair into the AVL tree
    public void put(K key, V value) {
        root = insert(root, key, value);
    }

    // Recursive function to insert a key-value pair into the subtree rooted with node
    private TreeNode insert(TreeNode node, K key, V value) {
        if (node == null) return new TreeNode(key, value);

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value; // Update the value for the existing key
            return node;
        }

        // Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check if this node became unbalanced
        int balance = getBalance(node);

        // If the node is unbalanced, there are 4 cases:

        // Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Get the value associated with the given key
    public V get(K key) {
        TreeNode node = get(root, key);
        return node != null ? node.value : null;
    }

    private TreeNode get(TreeNode node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) return get(node.left, key);
        if (key.compareTo(node.key) > 0) return get(node.right, key);
        return node;
    }

    // Remove a key-value pair from the AVL tree
    public void remove(K key) {
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode node, K key) {
        if (node == null) return null;

        // Perform standard BST deletion
        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node with one child or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: Get the in-order successor (smallest in the right subtree)
            TreeNode temp = minValueNode(node.right);
            node.key = temp.key;
            node.value = temp.value;
            node.right = delete(node.right, temp.key);
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Balance the node
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Utility to find the node with the smallest key in a subtree
    private TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Utility to print the tree in-order (keys in sorted order)
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();

        // Insert key-value pairs
        map.put(10, "Value10");
        map.put(20, "Value20");
        map.put(5, "Value5");
        map.put(15, "Value15");

        // Retrieve values
        System.out.println(map.get(10));  // Output: Value10
        System.out.println(map.get(15));  // Output: Value15

        // Print keys in sorted order
        System.out.print("Keys in sorted order: ");
        map.printInOrder();  // Output: 5 10 15 20

        // Remove a key
        map.remove(5);
        System.out.println(map.get(5));   // Output: null

        // Print keys in sorted order after removal
        System.out.print("Keys in sorted order after removal: ");
        map.printInOrder();  // Output: 10 15 20
    }
}
