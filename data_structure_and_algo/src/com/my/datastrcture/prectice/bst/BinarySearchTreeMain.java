package com.my.datastrcture.prectice.bst;


import com.my.datastrcture.codingninja.Test2.LinkedListNode;
import com.my.datastrcture.prectice.binarytree.BinaryTree;
import com.my.datastrcture.prectice.binarytree.BinaryTreeNode;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree tree = new BinaryTree();
        //int arr[] = {2,5,6,7,8,10};
        //8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        BinaryTreeNode<Integer> root = tree.takeInputLevelWise();
        tree.printLevelWise(root);
        /*LinkedListNode<Integer> head = bst.constructLinkedList(root);
        System.out.println("\nPrint Linked List");
        printLinkedList(head);*/
        BinarySearchTree.printNodesSumToS(root, 12);
    }

    private static void printLinkedList(LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
