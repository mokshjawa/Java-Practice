/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
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
    List<List<Integer>> tgt = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        for (int i = 0; i < findDepth(root, 0); i++)
        {
            tgt.add(i, new ArrayList<Integer>());
        }
        
        traverseTree(root, 0);
        return tgt;
    }
    
    public void addToList(TreeNode node, int depth)
    {
        /*
        try
        {
            tgt.get(depth);
        }
        catch (IndexOutOfBoundsExeception e)
        {
            tgt.add(depth, new ArrayList<Integer>());
        }
        */
        /*
        if (tgt.get(depth) == null)
        {
            tgt.add(depth, new ArrayList<Integer>());
        }
        */
        
        tgt.get(depth).add(node.val);
    }
    
    public void traverseTree(TreeNode node, int depth)
    {
        if (node != null)
        {
            addToList(node, depth);
            
            traverseTree(node.left, depth + 1);
            traverseTree(node.right, depth + 1);
        }
        
    }
    
    public int findDepth(TreeNode node, int depth)
    {
        if (node == null)
        {
            return depth;
        }
        return Math.max(findDepth(node.left, depth + 1), findDepth(node.right, depth + 1));
    }
    
    
}