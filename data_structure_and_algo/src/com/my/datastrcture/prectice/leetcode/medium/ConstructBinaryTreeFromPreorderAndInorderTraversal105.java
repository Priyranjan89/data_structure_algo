package com.my.datastrcture.prectice.leetcode.medium;

import com.my.datastrcture.prectice.leetcode.TreeCreation;
import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.Arrays;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.printTreeLevelWise;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 bt = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int preOrder[] = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        TreeNode root = bt.buildTree(preOrder, inOrder);
        printTreeLevelWise(root);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        int r = preorder[0];
        int index = 0;

        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == r){
                index = i;
            }
        }

        TreeNode root = new TreeNode(r);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

        return root;
    }

}
