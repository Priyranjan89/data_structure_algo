package com.my.datastrcture.prectice.bst;

public class CustomBSTMain {
    public static void main(String[] args) {
        CustomBST bst = new CustomBST();
        bst.isPresent(2);
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(5);
        bst.printBST();
    }
}
