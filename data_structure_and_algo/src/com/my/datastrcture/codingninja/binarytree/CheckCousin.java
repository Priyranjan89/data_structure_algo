package com.my.datastrcture.codingninja.binarytree;

public class CheckCousin {
    public static boolean checkIfSibling(BinaryTreeNode<Integer> root, int p1, int p2){
        if(root== null)
            return false;
        if(root.left != null && root.right != null){
            if((root.left.data == p1 && root.right.data == p2) ||
                    (root.left.data == p2 && root.right.data == p1)) {
                return true;
            }
        }
        return (checkIfSibling(root.left,p1,p2) || checkIfSibling(root.right,p1,p2));
    }

    // Returns 1 if a and b are cousins, otherwise 0
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        //1. The two Nodes should be on the same level in the binary tree.
        //2. The two Nodes should not be siblings (means that they should
        // not have the same parent Node).
        if ((level(root, p, 1) == level(root, q, 1)) && !(checkIfSibling(root, p, q))){
            return true;
        } else {
            return false;
        }
    }
    public static boolean isSibling(BinaryTreeNode<Integer> root, int data_one,
                                    int data_two) {
        if (root == null)
            return false;

        // Compare the two given nodes with
        // the childrens of current node
        if (root.left != null && root.right != null) {
            int left = root.left.data;
            int right = root.right.data;

            if (left == data_one && right == data_two)
                return true;
            else if (left == data_two && right == data_one)
                return true;
        }

        // Check for left subtree
        if (root.left != null)
            isSibling(root.left, data_one,
                    data_two);

        // Check for right subtree
        if (root.right != null)
            isSibling(root.right, data_one,
                    data_two);

        return false;
    }

    // Recursive function to find level of Node 'ptr' in a binary tree
    public static int level(BinaryTreeNode<Integer> root, int ptr, int lev) {
        // base cases
        if (root == null) return 0;
        if (root.data == ptr) return lev;

        // Return level if Node is present in left subtree
        int l = level(root.left, ptr, lev + 1);
        if (l != 0) return l;

        // Else search in right subtree
        return level(root.right, ptr, lev + 1);
    }

}
