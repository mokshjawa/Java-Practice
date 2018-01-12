/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
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
    int tgt = 0;
    
    public int longestUnivaluePath(TreeNode root) 
    {
        if (root == null)
        {
            return 0;
        }
        longestPath(root, root.val);
        return tgt;
    }
    
    public int longestPath(TreeNode node, int value)
    {
        if (node == null)
        {
            return 0;
        }
        
        int left = longestPath(node.left, node.val);
        int right = longestPath(node.right, node.val);
        
        tgt = Math.max(tgt, left + right);
        
        if (node.val == value)
        {
            return Math.max(left, right) + 1;
        }
        
        return 0;
    }
    
    /*
    public int longestPath(TreeNode root)
    { 
        if (root == null)
        {
            return 0;
        }
        
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        
        int leftVal = 0;
        int rightVal = 0;
        
        if (root.left != null && root.left.val == root.val)
        {
            leftVal += left + 1;
        }
        
        if (root.right != null && root.right.val == root.val)
        {
            rightVal += right + 1;
        }
        
        tgt = Math.max(tgt, leftVal + rightVal);
        
        return Math.max(leftVal, rightVal);        
    }
    */
}

