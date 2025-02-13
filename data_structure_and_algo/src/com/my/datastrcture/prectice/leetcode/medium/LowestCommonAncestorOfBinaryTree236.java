package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.buildTree;

public class LowestCommonAncestorOfBinaryTree236 {
    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree236 bt = new LowestCommonAncestorOfBinaryTree236();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = buildTree(preOrder, inOrder);
        TreeNode result = bt.lowestCommonAncestorLocal(root, new TreeNode(6), new TreeNode(10));
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestorLocal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
