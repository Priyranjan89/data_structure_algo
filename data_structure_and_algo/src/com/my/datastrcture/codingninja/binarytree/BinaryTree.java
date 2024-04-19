package com.my.datastrcture.codingninja.binarytree;

import java.util.Arrays;

public class BinaryTree {
    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + ":");
        if (root.left != null)
            System.out.print("L" + root.left.data + ",");
        if (root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }

        int rootData = preorder[0];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndexInInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootData) {
                rootIndexInInorder = i;
                break;
            }
        }
        if (rootIndexInInorder == -1)
            return null;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInInorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndexInInorder + 1, inorder.length);

        int lenLeftSubtree = leftInorder.length;

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, lenLeftSubtree + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, lenLeftSubtree + 1, preorder.length);

        BinaryTreeNode<Integer> leftChild = buildTree(leftPreorder, leftInorder);
        BinaryTreeNode<Integer> rightChild = buildTree(rightPreorder, rightInorder);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode<Integer> root = buildTree(preorder, inorder);
        printTreeDetailed(root);
    }
}