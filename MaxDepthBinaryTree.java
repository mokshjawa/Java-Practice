/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }
    
    public int findDepth(TreeNode node, int depth)
    {
        if (node == null)
        {
            return depth;
        }
        return Math.max(findDepth(node.left, depth + 1), findDepth(node.right, depth + 1));
    }
}