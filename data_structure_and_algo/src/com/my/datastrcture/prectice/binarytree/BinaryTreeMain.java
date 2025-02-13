package com.my.datastrcture.prectice.binarytree;

import com.my.datastrcture.codingninja.binarytree.Pair;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //BinaryTreeNode<Integer> root = binaryTree.createTree();
        //BinaryTreeNode<Integer> root = binaryTree.takeInput();
         BinaryTreeNode<Integer> root = binaryTree.takeInputBetter(true, 0, true);
        //BinaryTreeNode<Integer> root = binaryTree.takeInputLevelWise();
        //binaryTree.printTree(root);
        binaryTree.printTreeBetter(root);
       // binaryTree.printTreeLevelWise(root);
        //System.out.println("Number of node in Tree : "+binaryTree.numberOfNode(root));
    /*    System.out.println("Sum of all node in Tree : "+binaryTree.getSum(root));
        System.out.println("\nPrint tree order");
        System.out.println("PreOrder");
        binaryTree.preOrder(root);
        System.out.println("\npostOrder");
        binaryTree.postOrder(root);
        System.out.println("\ninOrder");
        binaryTree.inOrder(root);*/
        //System.out.println(binaryTree.largestNode(root));
        //BinaryTreeNode<Integer> root = binaryTree.takeInputLevelWise();
        //binaryTree.printTreeLevelWise(root);
        //binaryTree.printLevelWise(root);
        System.out.println("\n");
       /* binaryTree.insertDuplicateNode(root);
        binaryTree.printTreeLevelWise(root);*/
       /* Pair<Integer, Integer> pair = binaryTree.getMinAndMax(root);
        System.out.println("Minimum : "+pair.minimum+", Maximum : "+pair.maximum);*/
        //binaryTree.rootToLeafPathsSumToK(root, 13);
        //2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
    }
}
