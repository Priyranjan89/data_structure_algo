package com.my.datastrcture.kk.avltree;

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = null;

        for(int i=1; i <= 15; i++) {
            root = tree.insert(i);
        }

        System.out.println(tree.height());
        tree.printTreeLevelWise(root);
       tree.printInOrder();
    }
}
