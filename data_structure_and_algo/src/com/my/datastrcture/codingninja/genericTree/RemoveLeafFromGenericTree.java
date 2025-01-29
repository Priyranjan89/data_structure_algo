package com.my.datastrcture.codingninja.genericTree;
/*
* Steps to Approach:
Recursive Traversal:

Traverse the children of each node recursively.
After the children of a node are processed, check if that node has any remaining children.
If it has no children left, it is a leaf node, and it should be removed.
Base Case:

If the node is null, return null (no processing needed).
If the node has no children, it is a leaf node, so return null to remove it.
Post-Processing:

After processing all the children, we remove the children that have become leaf nodes during recursion.

Explanation:
TreeNode Class:

Each node in the generic tree is represented by the TreeNode class, which contains:
data: The value stored in the node.
children: A list of children nodes (since it is a generic tree, each node can have multiple children).
removeLeafNodes Method:

Base Case: If the root is null, return null.
Recursive Case: We iterate over the list of children of the current node:
If a child has no children (i.e., it is a leaf node), it is removed from the list of children.
If the child is not a leaf, we recursively call the removeLeafNodes method on it.
After processing all the children, we check if the current node itself has become a leaf (i.e., no children left). If it has, we return null to indicate it should be removed as well.
Removing Children in Reverse Order:

We traverse the children list from right to left (i = root.children.size() - 1) to avoid issues with shifting indices when removing elements from the list during iteration.
Returning the Modified Tree:

After processing, if the root still has children, it is returned. Otherwise, null is returned to indicate the node has been removed (if it became a leaf).
Example:
Input (tree):

markdown
Copy code
        10
      /  |  \
    20   30  40
        /  \
      40   50
The tree can be represented by the input:

Copy code
10 3 20 30 40 2 40 50 0 0 0 0
After removing the leaf nodes (20, 40, 50), the tree becomes:
markdown
Copy code
        10
         |
        30
Output:
Copy code
10
30
Time Complexity:
O(n): We traverse every node in the tree exactly once.
Space Complexity:
O(h): The recursion depth is proportional to the height of the tree.*/
public class RemoveLeafFromGenericTree {
   /* public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }

        // Iterate over the children of the current node
        for (int i = root.children.size() - 1; i >= 0; i--) {
            TreeNode<Integer> child = root.children.get(i);
            // Recursively remove leaf nodes from the children
            if (child.children.size() == 0) {
                // If the child has no children, remove it (it is a leaf)
                root.children.remove(i);
            } else {
                // Recursively call the function for non-leaf children
                removeLeafNodes(child);
            }
        }

        // After processing, if the root itself becomes a leaf (i.e., no children), return null
        if (root.children.size() == 0) {
            return null;
        }

        return root;  // Return the modified root after removing leaf nodes
    }*/

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root == null){
            return null;
        }

        for (int i = root.children.size() - 1; i >= 0; i--){
            TreeNode<Integer> child = root.children.get(i);
            if (child.children.size() == 0){
                root.children.remove(i);
            } else {
                removeLeafNodes(child);
            }
        }
        if (root.children.size() == 0){
            return null;
        }

        return root;
    }
}
