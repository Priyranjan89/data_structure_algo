package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;
import static com.my.datastrcture.prectice.leetcode.TreeCreation.printTreeLevelWise;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        ValidateBinarySearchTree98 bt = new ValidateBinarySearchTree98();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println(bt.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null){
            return true;
        }

        if ( low != null && root.val <= low){
            return false;
        }

        if (high != null && root.val >= high){
            return false;
        }

        boolean leftTree = helper(root.left, low, root.val);
        boolean rightTree = helper(root.right, root.val, high);

        return leftTree && rightTree;

        //return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
