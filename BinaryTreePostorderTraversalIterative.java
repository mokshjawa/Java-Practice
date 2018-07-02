/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> tgt = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
       
        while (root != null || !stack.isEmpty())
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
               
                if (visited.contains(root))
                {
                    tgt.add(root.val);
                    root = null;
                }
                else
                {
                    visited.add(root);
                    stack.push(root);
                    root = root.right;
                }
            }
        }
       
        return tgt;
    }
}
