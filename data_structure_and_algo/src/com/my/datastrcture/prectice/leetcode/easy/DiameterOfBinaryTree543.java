package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        DiameterOfBinaryTree543 bt = new DiameterOfBinaryTree543();
        /*int inOrder[] = {9, 3, 15, 20, 7};
        int preOrder[] = {3, 9, 20, 15, 7};*/
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = TreeCreation.buildTree(preOrder, inOrder);
        System.out.println(bt.diameterOfBinaryTree(root));
    }

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
         int leftHeight = height(root.left);
         int rightHeight = height(root.right);

         int dia = leftHeight + rightHeight + 1;
         diameter = Math.max(diameter, dia);

         return Math.max(leftHeight, rightHeight) + 1;
    }
}
