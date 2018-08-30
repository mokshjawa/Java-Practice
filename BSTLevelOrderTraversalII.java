/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    
    public void helper(TreeNode root, int depth, List<List<Integer>> tgt)
    {
        if (root == null)
        {
            return;
        }
        
        if (depth == tgt.size())
        {
            tgt.add(new ArrayList<Integer>());
        }
        
        tgt.get(depth).add(root.val);
        
        helper(root.left, depth + 1, tgt);
        helper(root.right, depth + 1, tgt);
    }
}
