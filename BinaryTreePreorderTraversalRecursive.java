/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> tgt = new ArrayList<>();
        helper(root, tgt);
        return tgt;
    }
    
    public void helper(TreeNode root, List<Integer> curr)
    {
        if (root != null)
        {
            curr.add(root.val);
            helper(root.left, curr);
            helper(root.right, curr);
        }
    }
}