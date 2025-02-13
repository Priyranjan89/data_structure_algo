package com.my.datastrcture.prectice.leetcode.hard;

import com.my.datastrcture.prectice.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Understanding Serialization and Deserialization
1. What is Serialization?
Serialization is the process of converting a tree into a string representation so that it can be stored or transmitted.

2. What is Deserialization?
Deserialization is the process of reconstructing the original tree from its serialized string.

Example
Tree Structure
markdown
Copy
Edit
      1
     / \
    2   3
       / \
      4   5
Serialized Representation
arduino
Copy
Edit
"1,2,null,null,3,4,null,null,5,null,null,"
Approach - Preorder Traversal (DFS)
We use Depth-First Search (DFS) in Preorder Traversal (Root → Left → Right).
Store "null" for missing children to preserve the tree structure.
Step-by-Step Explanation
Step 1: Serialization
Convert Tree to String (DFS Preorder Traversal)
Visit the root and store its value.
Recurse on the left child and store its value.
Recurse on the right child and store its value.
If a node is null, store "null".
Example Serialization
Input Tree
markdown
Copy
Edit
      1
     / \
    2   3
       / \
      4   5
Serialization Steps
Step	Node Processed	Serialized String So Far
1	1	"1,"
2	2	"1,2,"
3	null	"1,2,null,"
4	null	"1,2,null,null,"
5	3	"1,2,null,null,3,"
6	4	"1,2,null,null,3,4,"
7	null	"1,2,null,null,3,4,null,"
8	null	"1,2,null,null,3,4,null,null,"
9	5	"1,2,null,null,3,4,null,null,5,"
10	null	"1,2,null,null,3,4,null,null,5,null,"
11	null	"1,2,null,null,3,4,null,null,5,null,null,"
✅ Final Serialized Output:

arduino
Copy
Edit
"1,2,null,null,3,4,null,null,5,null,null,"
Step 2: Deserialization
Reconstruct Tree from Serialized String
Convert string into a queue (split by ",").
Process elements recursively:
If the current value is "null", return null (leaf node reached).
Otherwise, create a new TreeNode with the current value.
Recursively reconstruct left and right subtrees.
Example Deserialization
Serialized Input
arduino
Copy
Edit
"1,2,null,null,3,4,null,null,5,null,null,"
Reconstruction Steps
Step	Value Processed	Action Taken	Tree Constructed
1	1	Create root node 1	1
2	2	Create left child 2	1 → 2
3	null	Left child of 2 is null	1 → 2
4	null	Right child of 2 is null	1 → 2
5	3	Create right child 3	1 → 2, 3
6	4	Create left child 4	1 → 2, 3 → 4
7	null	Left child of 4 is null	1 → 2, 3 → 4
8	null	Right child of 4 is null	1 → 2, 3 → 4
9	5	Create right child 5	1 → 2, 3 → 4, 5
10	null	Left child of 5 is null	1 → 2, 3 → 4, 5
11	null	Right child of 5 is null	1 → 2, 3 → 4, 5
✅ Final Tree Matches Original Input!

Java Implementation
java
Copy
Edit
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {
    // Encodes a tree to a single string using Preorder Traversal.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree using a Queue.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Creating a sample tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize the tree
        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized (Preorder Traversal): " + codec.serialize(deserializedRoot));
    }
}
Complexity Analysis
Operation	Time Complexity	Space Complexity
Serialization	O(N)	O(N)
Deserialization	O(N)	O(N)
Key Takeaways
Uses DFS (Preorder Traversal) to serialize and deserialize.
Stores "null" for missing nodes to maintain structure.
Efficient - O(N) time complexity for both operations.
Preserves tree structure accurately.*/

public class SerializeAndDeserializeBinaryTree297 {

    // Encodes a tree to a single string using Preorder Traversal.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree using a Queue.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree297 codec = new SerializeAndDeserializeBinaryTree297();

        // Creating a sample tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize the tree
        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized (Preorder Traversal): " + codec.serialize(deserializedRoot));
    }
}
