package com.my.datastrcture.prectice.bst;

import com.my.datastrcture.prectice.binarytree.BinaryTreeNode;

public class BSTDeleteResponse {
    BinaryTreeNode<Integer> root;
    boolean delete;

    public BSTDeleteResponse(BinaryTreeNode<Integer> root, boolean delete) {
        this.root = root;
        this.delete = delete;
    }


}
