/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) 
    {
        if (root == null)
        {
            return true;
        }
        
        return isEqual(root.left, root.right);
    }
    
    public boolean isEqual(TreeNode left, TreeNode right)
    {
        if (left == null || right == null)
        {
            if (left == null && right == null)
            {
                return true;
            }
            
            return false;
        }
        
        if (left.val == right.val)
        {
            return isEqual(left.right, right.left) && isEqual(left.left, right.right);
        }
        else
        {
            return false;
        }
    }
}