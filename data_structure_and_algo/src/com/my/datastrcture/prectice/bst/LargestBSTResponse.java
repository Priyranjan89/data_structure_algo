package com.my.datastrcture.prectice.bst;

public class LargestBSTResponse {
    int min;
    int max;
    boolean isBST;
    int height;

    public LargestBSTResponse(){}

    public LargestBSTResponse(int min, int max, boolean isBST, int height) {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
        this.height = height;
    }
}
