/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> tgt = new ArrayList<>();
       
        helper(root, sum, new ArrayList<>(), tgt);
       
        return tgt;
    }
   
    public void helper(TreeNode root, int remainder, List<Integer> curr, List<List<Integer>> tgt)
    {
        if (root != null)
        {
            if (root.val == remainder)
            {
                if (root.left == null && root.right == null)
                {
                    curr.add(root.val);
                    tgt.add(new ArrayList<>(curr));
                   
                    curr.remove(curr.size() - 1);
                   
                    return;
                }
            }
           
            curr.add(root.val);
           
            helper(root.left, remainder - root.val, curr, tgt);
            helper(root.right, remainder - root.val, curr, tgt);
 
            curr.remove(curr.size() - 1);
         }
    }
}