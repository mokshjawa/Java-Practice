/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
    Integer prev;
    List<Integer> temp = new ArrayList<>();
    int max = 0;
    int curr = 0;
   
    public int[] findMode(TreeNode root)
    {
        if (root == null)
        {
            return new int[]{};
        }
       
        helper(root);
       
        int[] tgt = new int[temp.size()];
       
        for (int i = 0; i < temp.size(); i++)
        {
            tgt[i] = temp.get(i);
        }
       
        return tgt;
    }
   
    public void helper(TreeNode root)
    {
        if (root != null)
        {
            helper(root.left);
           
            if (prev != null && prev == root.val)
            {
                curr++;
            }
            else
            {
                curr = 1;
                prev = root.val;
            }
           
            if (curr == max)
            {
                temp.add(root.val);
            }
            else if (curr > max)
            {
                if (!(temp.size() == 1 && temp.get(0) == root.val))
                {
                    temp = new ArrayList<>();
                    temp.add(root.val);
                }               
                max = curr;
            }
               
            helper(root.right);
        }
    }
}