/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) 
    {
        if (root == null)
        {
            return 0;
        }
        
        int sum = 0;
        
        if (root.left != null && root.left.right == null & root.left.left == null)
        {
            sum += root.left.val;
        }
        
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}