package com.my.datastrcture.codingninja.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DiameterToReturn {
    int diameter;
    int height;

    public DiameterToReturn(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}
public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        DiameterToReturn answer = diameterHelper(root);
        return answer.diameter;
    }

    private static DiameterToReturn diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new DiameterToReturn(0, 0);
        }
        DiameterToReturn leftReturn = diameterHelper(root.left);
        DiameterToReturn rightReturn = diameterHelper(root.right);


        int longestDistance = leftReturn.height + rightReturn.height + 1; // OPTION_1
        int diameter = Math.max(leftReturn.diameter, Math.max(rightReturn.diameter, longestDistance)); // OPTION_2
        int height = Math.max(leftReturn.height, rightReturn.height) + 1; // OPTION_3

        return new DiameterToReturn(diameter, height);
    }

    static ArrayList<BinaryTreeNode<Integer>> path;

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {

        path = new ArrayList<>();
        findPath(root, node);
        for (int i = 0; i < path.size(); i++){
            printKNodesDown(path.get(i), k-i, i == 0 ? null : path.get(i-1));
        }
    }

    public static boolean findPath(BinaryTreeNode<Integer> root, int k){
        if (root == null){
            return false;
        }
        if (root.data == k){
            path.add(root);
            return true;
        }
        if (findPath(root.left, k) || findPath(root.right, k)){
            path.add(root);
            return true;
        }
        return false;
    }

    public static void printKNodesDown(BinaryTreeNode<Integer> root, int k, BinaryTreeNode<Integer> blocker){
        if (root == null || k < 0 || root == blocker){
            return;
        }

        if (k == 0){
            System.out.print(root.data+" ");
        }
        printKNodesDown(root.left, k-1, blocker);
        printKNodesDown(root.right, k-1, blocker);
    }

}
