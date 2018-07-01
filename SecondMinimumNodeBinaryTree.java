/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
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
    
    int min = Integer.MAX_VALUE;
    int sec = min;
    
    public int findSecondMinimumValue(TreeNode root) 
    {
        if (root == null)
        {
            return -1;
        }
        
        findMin(root);
        findSecondMin(root);
        
        if (sec == Integer.MAX_VALUE)
        {
            return -1;
        }
        
        return sec == Integer.MAX_VALUE ? -1 : sec;
    }
    
    public void findMin(TreeNode root)
    {
        if (root.left != null)
        {
            findMin(root.left);
        }
        
        if (root.val < min)
        {
            min = root.val;
        }
        
        if (root.right != null)
        {
            findMin(root.right);
        }
    }
    
    public void findSecondMin(TreeNode root)
    {
        if (root.left != null)
        {
            findSecondMin(root.left);
        }
        
        if (root.val < sec && root.val != min)
        {
            sec = root.val;
        }
        
        if (root.right != null)
        {
            findSecondMin(root.right);
        }
    }
}