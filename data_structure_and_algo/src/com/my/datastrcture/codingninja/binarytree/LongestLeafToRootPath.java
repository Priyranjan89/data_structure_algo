package com.my.datastrcture.codingninja.binarytree;

import java.util.ArrayList;

public class LongestLeafToRootPath {


    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root.left==null && root.right==null)
        {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            return ans;

        }
        int left=0;
        int right=0;
        if(root.left != null)
            left=height(root.left);
        if(root.right != null)
            right=height(root.right);

        if(left>right)
        {
            ArrayList<Integer> l =longestRootToLeafPath(root.left);
            l.add(root.data);
            return l;
        }
        else {
            ArrayList<Integer> r =longestRootToLeafPath(root.right);
            r.add(root.data);
            return r;
        }
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
