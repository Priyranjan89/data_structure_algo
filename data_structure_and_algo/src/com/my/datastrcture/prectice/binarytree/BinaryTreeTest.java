package com.my.datastrcture.prectice.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {
    public static void main(String[] args) {
        int preOrder[] = {1, 2, 4, 5, 8, 3, 6, 7, 9};
        int inOrder[] = {4, 2, 8, 5, 1, 6, 3, 7, 9};
        int postOrder[] = {4, 8, 5, 2, 6, 9, 7, 3, 1};
        BinaryTreeNode<Integer> rootIn = buildTreeIn(preOrder, inOrder);
        printBinaryTreeLevelWise(rootIn);

        BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder);
        printBinaryTreeLevelWise(root);
    }

    public static BinaryTreeNode<Integer> buildTreeIn(int[] preOrder, int[] inOrder) {
        int siPre = 0;
        int eiPre = preOrder.length-1;
        int siIn = 0;
        int eiIn = inOrder.length-1;
        return buildTreeHelperIn(preOrder, siPre, eiPre, inOrder, siIn, eiIn);
    }

    private static BinaryTreeNode<Integer> buildTreeHelperIn(int[] preOrder, int siPre, int eiPre,
                                                           int[] inOrder, int siIn, int eiIn) {
        if (siPre > eiPre){
            return null;
        }
        int rootDate = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootDate);

        int rootIndex = -1;
        for (int i = siIn; i <= inOrder.length; i++){
            if (rootDate == inOrder[i]){
                rootIndex = i;
                break;
            }
        }
        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;
        int eiPreRight = eiPre;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubTreeLength -1;
        int siPreRight = eiPreLeft + 1;



        root.left = buildTreeHelperIn(preOrder, siPreLeft, eiPreLeft, inOrder, siInLeft, eiInLeft);
        root.right = buildTreeHelperIn(preOrder, siPreRight, eiPreRight, inOrder, siInRight, eiInRight);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        return buildTreeHelper(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int siPost, int eiPost,
                                                           int[] inOrder, int siIn, int eiIn) {

        if (siPost > eiPost){
            return null;
        }
        int rootDate = postOrder[eiPost];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootDate);

        int rootIndex = -1;
        for (int i = siIn; i <= inOrder.length; i++){
            if (rootDate == inOrder[i]){
                rootIndex = i;
                break;
            }
        }

        int siPostLeft = siPost;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;
        int eiPostRight = eiPost - 1;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;
        int eiPostLeft = siPostLeft + leftSubTreeLength -1;
        int siPostRight = eiPostLeft + 1;

        root.left = buildTreeHelper(postOrder, siPostLeft, eiPostLeft, inOrder, siInLeft, eiInLeft);
        root.right = buildTreeHelper(postOrder, siPostRight, eiPostRight, inOrder, siInRight, eiInRight);

        return root;
    }

    public static void printBinaryTreeLevelWise(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }

        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);

        while (!pendingChild.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChild.poll();

            System.out.print(front.data+" : ");

            if (front.left != null){
                System.out.print("L"+front.left.data+", ");
                pendingChild.add(front.left);
            }
            if (front.right != null){
                System.out.print("R"+front.right.data);
                pendingChild.add(front.right);
            }
            System.out.println();
        }
    }
}
