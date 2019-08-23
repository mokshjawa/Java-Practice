/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
        {
            return new LinkedList<>();
        }
        
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end)
    {
        List<TreeNode> tgt = new LinkedList<>();
        
        if (start > end)
        {
            tgt.add(null);
        }
        else if (start == end)
        {
            TreeNode root = new TreeNode(start);
            tgt.add(root);
        }
        else 
        {
            for (int i = start; i <= end; i++)
            {
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);
                
                for (TreeNode l : left)
                {
                    for (TreeNode r : right)
                    {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        tgt.add(root);
                    }
                }
            }
        }
        
        return tgt;
    }
}