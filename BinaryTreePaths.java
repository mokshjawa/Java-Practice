/*

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> tgt = new ArrayList<>();
       
        if (root == null)
        {
            return tgt;
        }
       
        helper(root, "", tgt);
       
        return tgt;
    }
   
    public void helper(TreeNode root, String str, List<String> curr)
    {
        if (root.left == null && root.right == null)
        {
            curr.add(str + root.val);
        }
       
        if (root.left != null)
        {
            helper(root.left, str + root.val + "->", curr);
        }
       
        if (root.right != null)
        {
            helper(root.right, str + root.val + "->", curr);
        }
    }
}