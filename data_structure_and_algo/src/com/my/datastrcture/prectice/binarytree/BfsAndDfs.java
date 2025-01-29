package com.my.datastrcture.prectice.binarytree;

/*Breadth-First Search (BFS) and Depth-First Search (DFS) are two fundamental graph/tree traversal algorithms used to explore nodes and edges systematically.
1. Breadth-First Search (BFS):
BFS explores nodes level by level (breadth-wise). It starts at the root (or any starting node) and explores all its neighbors first, then moves to the next level (children of all neighbors), and so on.
BFS uses a queue (FIFO - First In First Out) to keep track of the next nodes to visit.
Example of BFS:
Consider the following binary tree:

markdown
Copy code
        1
       / \
      2   3
     / \   \
    4   5   6
BFS Traversal: Starting from the root (node 1):
Level 1: Visit node 1 (root).
Level 2: Visit its children 2 and 3.
Level 3: Visit children of 2 and 3 → nodes 4, 5, and 6.
BFS Traversal Order: 1, 2, 3, 4, 5, 6

BFS Algorithm:
Start with a queue and enqueue the root node.
While the queue is not empty:
Dequeue the front node.
Visit the node.
Enqueue all its unvisited child nodes.
Code for BFS:
java
Copy code
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class BFSExample {
    public static void bfs(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // Construct the tree from the example
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);

        System.out.println("BFS Traversal:");
        bfs(root);  // Output: 1 2 3 4 5 6
    }
}
2. Depth-First Search (DFS):
DFS explores as far as possible along each branch before backtracking (depth-wise). It goes deep into the tree/graph by following one branch, then backtracks and explores the next branch.
DFS can be implemented using either a stack (LIFO - Last In First Out) or recursion.
Example of DFS:
Consider the same binary tree:

markdown
Copy code
        1
       / \
      2   3
     / \   \
    4   5   6
DFS Traversal: Starting from the root (node 1):
Visit node 1, then go deep into the left subtree.
Visit node 2, then visit node 4 (left child of 2).
Backtrack to node 2, then visit node 5 (right child of 2).
Backtrack to node 1, then visit node 3, and then visit its right child node 6.
DFS Traversal Order (Pre-order): 1, 2, 4, 5, 3, 6

DFS Variants:
There are three common types of DFS for trees:

Pre-order (root-left-right): Visit the root, then traverse the left subtree, then the right subtree.
In-order (left-root-right): Traverse the left subtree, then visit the root, then traverse the right subtree.
Post-order (left-right-root): Traverse the left subtree, then the right subtree, and finally visit the root.
In the above example, we used Pre-order traversal.

Code for DFS (Pre-order):
java
Copy code
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class DFSExample {
    public static void dfsPreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        // Visit the node (Pre-order)
        System.out.print(root.data + " ");

        // Recurse on the left subtree
        dfsPreOrder(root.left);

        // Recurse on the right subtree
        dfsPreOrder(root.right);
    }

    public static void main(String[] args) {
        // Construct the tree from the example
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);

        System.out.println("DFS Pre-order Traversal:");
        dfsPreOrder(root);  // Output: 1 2 4 5 3 6
    }
}
Key Differences Between BFS and DFS:
Aspect	BFS	DFS
Traversal	Level by level (breadth-wise)	Depth-first (one branch at a time)
Data Structure	Queue (FIFO)	Stack (LIFO) or Recursion
Use Case	Best for shortest path or level-order traversal	Best for exploring deep paths or finding components
Time Complexity	O(n)	O(n)
Space Complexity	O(n) (due to queue)	O(h) where h = height of tree (due to recursion/stack)
BFS vs. DFS Example Visualization:
BFS:
scss
Copy code
1. Visit node 1 (root)
2. Visit node 2 and 3 (level 2)
3. Visit node 4, 5, and 6 (level 3)
Traversal Order: 1, 2, 3, 4, 5, 6
DFS (Pre-order):
css
Copy code
1. Visit node 1 (root)
2. Visit node 2 (left subtree)
3. Visit node 4 (left of 2)
4. Backtrack to node 2, visit node 5 (right of 2)
5. Backtrack to root, visit node 3
6. Visit node 6 (right of 3)
Traversal Order: 1, 2, 4, 5, 3, 6
When to Use BFS vs. DFS:
BFS is typically used when:
You need the shortest path in an unweighted graph.
You want to explore all nodes at the same depth.
DFS is typically used when:
You need to explore deep branches of the tree/graph.
You want to find connected components or paths in a graph/tree.
Let me know if you'd like more examples or further details!*/


import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfs {
    public static void bfs(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void dfsPreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        // Visit the node (Pre-order)
        System.out.print(root.data + " ");

        // Recurse on the left subtree
        dfsPreOrder(root.left);

        // Recurse on the right subtree
        dfsPreOrder(root.right);
    }

    public static void main(String[] args) {
        // Construct the tree from the example
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);

        System.out.println("BFS Traversal:");
        bfs(root);  // Output: 1 2 3 4 5 6

        System.out.println("\n");
        System.out.println("DFS Pre-order Traversal:");
        dfsPreOrder(root);  // Output: 1 2 4 5 3 6
    }
}
