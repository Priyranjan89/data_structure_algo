package com.my.datastrcture.prectice.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinTree {
    public BTNode takeInputRecursive(boolean isRoot, int parentData, boolean isLeft){
        if (isRoot){
            System.out.println("Please enter root Data: ");
        } else {
            if (isLeft){
                System.out.println("Please enter "+parentData+" left child data : ");
            } else {
                System.out.println("Please enter "+parentData+" right child data : ");
            }
        }

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();;
        if (data == -1){
            return null;
        }
        BTNode root = new BTNode(data);
        root.left = takeInputRecursive(false, data, true);
        root.right = takeInputRecursive(false, data, false);

        return root;
    }

    public void printTree(BTNode root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        if (root.left != null){
            System.out.print("L : "+root.left.data+", ");
        }
        if (root.right != null){
            System.out.print("R : "+root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    public BTNode takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter root data: ");
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }

        BTNode root = new BTNode(data);
        Queue<BTNode> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        while (!pendingNode.isEmpty()){
            BTNode front = pendingNode.poll();
            System.out.println("Please enter left child data for "+front.data);
            int left = sc.nextInt();
            if (left != -1){
                BTNode leftChild = new BTNode(left);
                front.left = leftChild;
                pendingNode.add(leftChild);
            }

            System.out.println("Please enter right child data for "+front.data);
            int right = sc.nextInt();
            if (right != -1){
                BTNode rightChild = new BTNode(right);
                front.right = rightChild;
                pendingNode.add(rightChild);
            }
        }

        return root;
    }

    public void printTreeLevelWise(BTNode root){
        if (root == null){
            return;
        }
        Queue<BTNode> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        while (!pendingNode.isEmpty()){
            BTNode front = pendingNode.poll();

            System.out.print(front.data+" : ");
            if (front.left != null){
                System.out.print("L : "+front.left.data+", ");
                pendingNode.add(front.left);
            }
            if (front.right != null){
                System.out.print("R : "+front.right.data);
                pendingNode.add(front.right);
            }
            System.out.println();
        }
    }
    public static int getSum(BTNode root) {
        if (root == null){
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);
        return (root.data + left + right);
    }
}
