package com.my.datastrcture.prectice.bst;

import com.my.datastrcture.prectice.binarytree.BinaryTreeNode;

public class CustomBST {
    private BinaryTreeNode<Integer> root;
    private int size;

    public int size(){
        return size;
    }

    public boolean isPresent(int x){
        return isPresentHelper(root, x);
    }
    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x){
        if (node == null){
            return false;
        }
        if (node.data == x){
            return true;
        }
        if (x < node.data){
            return isPresentHelper(node.left, x);
        } else {
            return isPresentHelper(node.right, x);
        }
    }

    public void insert(int data){
        root = insertHelper(root, data);
        size++;
    }
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int data){
        if (node == null){
            return new BinaryTreeNode<>(data);
        }

        if (data >= node.data){
            node.right = insertHelper(node.right, data);
        } else {
            node.left = insertHelper(node.left, data);
        }
        return node;
    }

    public void printBST(){
        printBST(root);
    }

    private static void printBST(BinaryTreeNode<Integer> node){
        if (node == null){
            return;
        }
        System.out.print(node.data + ":");
        if (node.left != null) {
            System.out.print("L" + node.left.data + ", ");
        }
        if (node.right != null) {
            System.out.print("R" + node.right.data);
        }
        System.out.println();
        printBST(node.left);
        printBST(node.right);
    }

    public boolean remove(int x) {
        BSTDeleteResponse response = removeHelper(root, x);
        if (response.delete){
            size--;
        }
        return response.delete;
    }

    private static BSTDeleteResponse removeHelper(BinaryTreeNode<Integer> root, int x) {
        if (root == null){
            return new BSTDeleteResponse(null, false);
        }
        if (root.data < x){
            BSTDeleteResponse outputRight = removeHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }
        if (root.data > x){
            BSTDeleteResponse outputLeft = removeHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }
        //0 child
        if (root.left == null && root.right == null){
            return new BSTDeleteResponse(null, true);
        }
        //only left child
        if (root.left != null && root.right == null){
            return new BSTDeleteResponse(root.left, true);
        }
        //only right child
        if (root.left == null && root.right != null){
            return new BSTDeleteResponse(root.right, true);
        }
        int rightMin = minimum(root.right);
        root.data = rightMin;
        BSTDeleteResponse outputRight = removeHelper(root.right, rightMin);
        root.right = outputRight.root;
        return new BSTDeleteResponse(root, true);
    }


    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}
