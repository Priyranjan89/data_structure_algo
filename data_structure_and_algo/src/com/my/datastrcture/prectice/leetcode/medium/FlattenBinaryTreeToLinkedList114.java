package com.my.datastrcture.prectice.leetcode.medium;


import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;
import static com.my.datastrcture.prectice.leetcode.TreeCreation.printTreeLevelWise;

public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {
        BinaryTreeRightSideView199 bt = new BinaryTreeRightSideView199();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = buildTree(preOrder, inOrder);
        flatten(root);
        printTreeLevelWise(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode current = root;
        while (current != null){
            if (current.left != null){
                TreeNode temp = current.left;
                while (temp.right != null){
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
