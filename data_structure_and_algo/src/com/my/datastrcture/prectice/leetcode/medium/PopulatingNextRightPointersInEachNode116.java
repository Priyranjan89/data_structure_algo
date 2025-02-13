package com.my.datastrcture.prectice.leetcode.medium;

public class PopulatingNextRightPointersInEachNode116 {
    public static void main(String[] args) {


    }
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Node leftMost= root;

        while (leftMost.left != null){
            Node current = leftMost;
            while (current != null){
                current.left.next = current.right;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
