package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

public class CousinsInBinaryTree993 {
    public static void main(String[] args) {
        CousinsInBinaryTree993 bt = new CousinsInBinaryTree993();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        System.out.println(bt.isCousins(root, 6, 10));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        
        return (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    private boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
        if(root == null) {
            return false;
        }
        return (
                (root.left == x && root.right == y) || (root.left == y && root.right == x)
                        || isSibling(root.left, x, y) || isSibling(root.right, x, y)
        );
    }

    private int level(TreeNode root, TreeNode x, int lev) {
        if(root == null) {
            return 0;
        }

        if(root == x) {
            return lev;
        }

        int l = level(root.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(root.right, x, lev+1);
    }

    private TreeNode findNode(TreeNode root, int x) {
        if (root == null){
            return null;
        }
        if (root.val == x){
            return root;
        }
        TreeNode node = findNode(root.left, x);
        if (node != null){
            return node;
        }

        return findNode(root.right, x);
    }
}
