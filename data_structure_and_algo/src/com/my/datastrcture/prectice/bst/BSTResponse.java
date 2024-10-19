package com.my.datastrcture.prectice.bst;

public class BSTResponse {
    boolean isBST;
    int min;
    int max;

    public BSTResponse(){}

    public BSTResponse(boolean isBST, int min, int max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}
