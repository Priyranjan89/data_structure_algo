package com.my.datastrcture.kk.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    private Node root;

    public AVLTree() {
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node insert(int value) {
        root = insert(value, root);
        return root;
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            return node; // Duplicate values not allowed
        }

        // Update height after insertion
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Balance the tree
        return balance(node);
    }

    /*This function is responsible for maintaining the balance of the AVL tree after an insertion. The AVL tree is a self-balancing binary search tree, and it must satisfy the balance property:

    The height difference (balance factor) between the left and right subtrees of any node should be at most 1.

    If the balance factor goes outside this range (> 1 or < -1), we perform rotations to restore balance.

    Step-by-Step Breakdown
    1. Compute the Balance Factor
    java
    Copy
    Edit
    int balanceFactor = height(node.left) - height(node.right);
    The balance factor is the difference between the height of the left subtree and the height of the right subtree.
    It tells us whether the tree is:
    Balanced (-1, 0, or 1) → No rotation needed.
    Left-heavy (balanceFactor > 1) → Left subtree is too tall.
    Right-heavy (balanceFactor < -1) → Right subtree is too tall.
    2. Handle Left-Heavy Case (balanceFactor > 1)
    java
    Copy
    Edit
    if (balanceFactor > 1) { // Left-heavy
        if (height(node.left.left) >= height(node.left.right)) {
            return rightRotate(node); // Left-Left case
        } else {
            node.left = leftRotate(node.left);
            return rightRotate(node); // Left-Right case
        }
    }
    When balanceFactor > 1, the left subtree is too tall. We need to rebalance it.

    (a) Left-Left Case (LL)
    This happens when the imbalance occurs due to an insertion in the left subtree of the left child.
    We right-rotate the node.
    ✅ Example

    markdown
    Copy
    Edit
          10
         /
        5
       /
      2
    After Right Rotation (rightRotate(10))

    markdown
    Copy
    Edit
          5
         / \
        2   10
    (b) Left-Right Case (LR)
    This happens when the imbalance occurs due to an insertion in the right subtree of the left child.
    We first left-rotate the left child, and then right-rotate the node.
    ✅ Example

    markdown
    Copy
    Edit
          10
         /
        5
         \
          7
    Step 1: Left Rotate on 5 (leftRotate(5))

    markdown
    Copy
    Edit
          10
         /
        7
       /
      5
    Step 2: Right Rotate on 10 (rightRotate(10))

    markdown
    Copy
    Edit
          7
         / \
        5   10
    3. Handle Right-Heavy Case (balanceFactor < -1)
    java
    Copy
    Edit
    if (balanceFactor < -1) { // Right-heavy
        if (height(node.right.right) >= height(node.right.left)) {
            return leftRotate(node); // Right-Right case
        } else {
            node.right = rightRotate(node.right);
            return leftRotate(node); // Right-Left case
        }
    }
    When balanceFactor < -1, the right subtree is too tall. We need to rebalance it.

    (a) Right-Right Case (RR)
    This happens when the imbalance occurs due to an insertion in the right subtree of the right child.
    We left-rotate the node.
    ✅ Example

    markdown
    Copy
    Edit
        5
         \
          10
            \
             15
    After Left Rotation (leftRotate(5))

    markdown
    Copy
    Edit
        10
       /  \
      5    15
    (b) Right-Left Case (RL)
    This happens when the imbalance occurs due to an insertion in the left subtree of the right child.
    We first right-rotate the right child, and then left-rotate the node.
    ✅ Example

    markdown
    Copy
    Edit
        5
         \
          10
         /
        7
    Step 1: Right Rotate on 10 (rightRotate(10))

    markdown
    Copy
    Edit
        5
         \
          7
           \
            10
    Step 2: Left Rotate on 5 (leftRotate(5))

    markdown
    Copy
    Edit
          7
         /  \
        5    10
    4. Return the Balanced Node
    java
    Copy
    Edit
    return node;
    If no rotations are required (balance factor is -1, 0, or 1), return the node as-is.
    Summary
    Check Balance Factor:
    > 1 → Left-heavy → Fix with Right Rotations
    < -1 → Right-heavy → Fix with Left Rotations
    Left-Heavy Cases:
    LL Case → Right Rotation
    LR Case → Left Rotation + Right Rotation
    Right-Heavy Cases:
    RR Case → Left Rotation
    RL Case → Right Rotation + Left Rotation
    This function ensures that every node in the AVL tree remains balanced after each insertion.
    */
    private Node balance(Node node) {
        int balanceFactor = height(node.left) - height(node.right);

        if (balanceFactor > 1) { // Left-heavy
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node); // Left-Left case
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node); // Left-Right case
            }
        }

        if (balanceFactor < -1) { // Right-heavy
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node); // Right-Right case
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node); // Right-Left case
            }
        }

        return node;
    }

    private Node leftRotate(Node child) {
        Node parent = child.right;
        Node temp = parent .left;

        // Perform rotation
        parent.left = child;
        child.right = temp;

        // Update heights
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;

        return parent;
    }

    private Node rightRotate(Node parent) {

        Node child = parent.left;
        Node temp = child.right;

        // Perform rotation
        child.right = parent;
        parent.left = temp;

        // Update heights
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public void printTreeLevelWise(Node root){
        if (root == null){
            return;
        }
        Queue<Node> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        while (!pendingNode.isEmpty()){
            Node front = pendingNode.poll();

            System.out.print(front.value+" : ");
            if (front.left != null){
                System.out.print("L : "+front.left.value+", ");
                pendingNode.add(front.left);
            }
            if (front.right != null){
                System.out.print("R : "+front.right.value);
                pendingNode.add(front.right);
            }
            System.out.println();
        }
    }
}
