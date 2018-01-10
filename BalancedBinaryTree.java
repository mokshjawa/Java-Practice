/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean result = true;
    
    public boolean isBalanced(TreeNode root) 
    {
        depth(root);
        return result;
    }
    
    public int depth(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        
        int l = depth(node.left);
        int r = depth(node.right);
        
        if (Math.abs(l-r) > 1)
        {
            result = false;
        }
        
        return 1 + Math.max(l, r);
    }
}