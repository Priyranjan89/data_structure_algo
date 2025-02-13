package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;
import static com.my.datastrcture.prectice.leetcode.TreeCreation.printTreeLevelWise;

public class InvertBinaryTree226 {
    public static void main(String[] args) {
        InvertBinaryTree226 bt = new InvertBinaryTree226();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = buildTree(preOrder, inOrder);
        TreeNode result = bt.invertTree(root);
        printTreeLevelWise(result);

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
