package com.my.datastrcture.codingninja.genericTree;

import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<Integer>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}
