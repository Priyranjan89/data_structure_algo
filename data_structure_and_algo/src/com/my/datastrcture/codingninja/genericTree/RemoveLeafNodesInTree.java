package com.my.datastrcture.codingninja.genericTree;

public class RemoveLeafNodesInTree {

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }// if root is null return null
        if (root.children.size() == 0) {// if root itself is leaf return null
            return null;
        }
        // if root.children is a leaf node
        // then delete it from children vector
        for (int i = 0; i < root.children.size(); i++) {

            TreeNode child = root.children.get(i);

            // if it is  a leaf
            if (child.children.size() == 0) {

                // shifting the vector to left
                // after the point i
                for (int j = i; j < root.children.size() - 1; j++)
                    root.children.set(j, root.children.get(j + 1));

                // delete the last element
                root.children.remove(root.children.size() - 1);

                i--;
            }
        }

        // Remove all leaf node
        // of children of root
        for (int i = 0; i < root.children.size(); i++) {

            // call function for root.children
            root.children.set(i, removeLeafNodes(root.children.get(i)));
        }
        return root;
    }



}
