/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> tgt = new ArrayList<>();
        helper(root, 0, tgt);
        return tgt;
    }
    
    public void helper(TreeNode root, int depth, List<Integer> tgt)
    {
        if (root == null)
        {
            return;
        }
        
        if (depth == tgt.size())
        {
            tgt.add(root.val);
        }
        
        helper(root.right, depth + 1, tgt);
        helper(root.left, depth + 1, tgt);
    }
}
