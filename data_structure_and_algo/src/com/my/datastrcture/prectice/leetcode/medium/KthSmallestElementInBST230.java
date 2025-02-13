package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;

public class KthSmallestElementInBST230 {
    public static void main(String[] args) {
        KthSmallestElementInBST230 bt = new KthSmallestElementInBST230();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println(bt.kthSmallest(root, 3));
    }

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = helper(root, k);
        return result.val;
    }

    private TreeNode helper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }

        return helper(root.right, k);
    }
}
