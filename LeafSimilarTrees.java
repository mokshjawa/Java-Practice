/*
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Note:

Both of the given trees will have between 1 and 100 nodes.
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        if (root1 == null || root2 == null)
        {
            if (root1 == null && root2 == null)
            {
                return true;
            }
            
            return false;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root1);
        s2.push(root2);
        
        while (!s1.isEmpty() && !s2.isEmpty())
        {
            if (dfs(s1) != dfs(s2))
            {
                return false;
            }
        }
        
        return (s1.isEmpty() && s2.isEmpty());
        
        
    }
    
    public int dfs(Stack<TreeNode> s)
    {
        while (true)
        {
            TreeNode curr = s.pop();
        
            if (curr.right != null)
            {
                s.push(curr.right);
            }

            if (curr.left != null)
            {
                s.push(curr.left);
            }

            if (curr.left == null && curr.right == null)
            {
                return curr.val;
            }
        }
    }
}
