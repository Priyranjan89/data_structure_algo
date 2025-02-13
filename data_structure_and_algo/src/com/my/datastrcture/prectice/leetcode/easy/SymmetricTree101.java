package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree101 {
    public static void main(String[] args) {
        SymmetricTree101 bt = new SymmetricTree101();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        System.out.println(bt.isSymmetric(root));
    }
    public boolean isSymmetric1(TreeNode root) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.val == n2.val && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }

}
