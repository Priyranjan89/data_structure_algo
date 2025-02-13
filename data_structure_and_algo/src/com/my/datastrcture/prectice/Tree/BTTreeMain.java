package com.my.datastrcture.prectice.Tree;

public class BTTreeMain {
    public static void main(String[] args) {
        BinTree bt = new BinTree();
        BTNode root = bt.takeInputLevelWise();
        bt.printTreeLevelWise(root);
    }
}
