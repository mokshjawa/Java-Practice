/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> tgt = new LinkedList<>();
        boolean reverse = true;
        
        if (root == null)
        {
            return tgt;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        
        while (!s1.isEmpty())
        {
            List<Integer> layer = new LinkedList<>();
            
            while (!s1.isEmpty())
            {
                TreeNode curr = s1.pop();
                layer.add(curr.val);
                
                if (reverse)
                {
                    // left, right
                    if (curr.left != null)
                    {
                        s2.push(curr.left);
                    }
                    
                    if (curr.right != null)
                    {
                        s2.push(curr.right);
                    }
                }
                else
                {
                    // right, left
                    if (curr.right != null)
                    {
                        s2.push(curr.right);
                    }
                    
                    if (curr.left != null)
                    {
                        s2.push(curr.left);
                    }
                }
            }
            
            tgt.add(layer);
            s1 = s2;
            s2 = new Stack<TreeNode>();
            reverse = !reverse;
        }
        
        return tgt;
    }
}
