package com.my.datastrcture.prectice.leetcode;

import com.my.datastrcture.prectice.Tree.BTNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeCreation {
    public static TreeNode takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data: ");

        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        TreeNode root = new TreeNode(rootData);
        Queue<TreeNode> pendingChild = new LinkedList<>();
        pendingChild.add(root);

        while (!pendingChild.isEmpty()) {
            TreeNode front = pendingChild.poll();

            System.out.println("Enter the left child of " + front.val);
            int left = sc.nextInt();
            if (left != -1) {
                TreeNode leftChild = new TreeNode(left);
                front.left = leftChild;
                pendingChild.add(leftChild);
            }

            System.out.println("Enter the right child of " + front.val);
            int right = sc.nextInt();
            if (right != -1) {
                TreeNode rightChild = new TreeNode(right);
                front.right = rightChild;
                pendingChild.add(rightChild);
            }
        }
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }

        int rootData = preorder[0];
        TreeNode root = new TreeNode(rootData);
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

        TreeNode leftChild = buildTree(leftPreorder, leftInorder);
        TreeNode rightChild = buildTree(rightPreorder, rightInorder);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public  static void printTreeLevelWise(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        while (!pendingNode.isEmpty()){
            TreeNode front = pendingNode.poll();

            System.out.print(front.val+" : ");
            if (front.left != null){
                System.out.print("L : "+front.left.val+", ");
                pendingNode.add(front.left);
            }
            if (front.right != null){
                System.out.print("R : "+front.right.val);
                pendingNode.add(front.right);
            }
            System.out.println();
        }
    }
}
