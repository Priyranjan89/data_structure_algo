package com.my.datastrcture.prectice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
/*
* To solve the problem of determining whether two nodes p and q are cousins in a binary tree, we need to check two conditions:

The nodes p and q must be at the same level.
The nodes p and q must have different parents.
Approach:
Perform a level-order traversal (BFS) of the tree.
For each node, check its parent and its level.
If both nodes p and q are found, compare their levels and parents:
If the levels are the same and the parents are different, the nodes are cousins.
Algorithm:
Use a queue to perform the level-order traversal.
While traversing, for each node, check if it's either p or q and record its parent and level.
If both nodes are found at the same level but have different parents, return true.
If you finish the traversal and they don't satisfy the conditions, return false.
* */

public class CousinCheck {
    static class CousinInfo {
        BinaryTreeNode<Integer> node;
        BinaryTreeNode<Integer> parent;
        int level;

        public CousinInfo(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        if (root == null) return false;

        // Perform level order traversal (BFS)
        Queue<CousinInfo> queue = new LinkedList<>();
        queue.add(new CousinInfo(root, null, 0));

        CousinInfo pInfo = null, qInfo = null;

        while (!queue.isEmpty()) {
            CousinInfo current = queue.poll();
            BinaryTreeNode<Integer> node = current.node;
            BinaryTreeNode<Integer> parent = current.parent;
            int level = current.level;

            // Check if current node is either p or q
            if (node.data == p) {
                pInfo = new CousinInfo(node, parent, level);
            }
            if (node.data == q) {
                qInfo = new CousinInfo(node, parent, level);
            }

            // If both nodes are found, break the loop
            if (pInfo != null && qInfo != null) break;

            // Add the left and right children to the queue
            if (node.left != null) {
                queue.add(new CousinInfo(node.left, node, level + 1));
            }
            if (node.right != null) {
                queue.add(new CousinInfo(node.right, node, level + 1));
            }
        }

        // If both nodes are found, check if they are cousins
        if (pInfo != null && qInfo != null) {
            // They are cousins if they are on the same level and have different parents
            return (pInfo.level == qInfo.level) && (pInfo.parent != qInfo.parent);
        }

        return false;  // One or both nodes were not found
    }

    public static void main(String[] args) {
        // Sample tree: [5, 6, 10, 2, 3, 4, -1, -1, -1, -1, 9, -1, -1, -1, -1]
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(3);
        root.right.left = new BinaryTreeNode<>(4);
        root.left.right.left = new BinaryTreeNode<>(9);

        int p = 2;  // Node p
        int q = 4;  // Node q

        System.out.println(isCousin(root, p, q));  // Output: true
    }
    /*
Explanation:
NodeInfo Class: A helper class to store the node, its parent, and its level during traversal.
Queue (Level-Order Traversal): We use a queue to process nodes level by level. For each node, we check if it's p or q and keep track of its parent and level.
Parent and Level Check: If both nodes are found, we check their levels and parents to determine if they are cousins.
Time Complexity:
O(n): Where n is the number of nodes in the tree. We perform a BFS, visiting each node exactly once.
Constraints:
1 ≤ N ≤ 10^5: The solution works efficiently for large trees with up to 100,000 nodes.
*/
}
