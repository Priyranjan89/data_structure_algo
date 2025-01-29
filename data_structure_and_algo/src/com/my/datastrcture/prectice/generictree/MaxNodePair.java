package com.my.datastrcture.prectice.generictree;

public class MaxNodePair<T> {
    TreeNode<T> node;
    T sum;

    public MaxNodePair(TreeNode<T> node, T sum) {
        this.node = node;
        this.sum = sum;
    }
}
