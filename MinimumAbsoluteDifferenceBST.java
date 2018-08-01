/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
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
    public int getMinimumDifference(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
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
                list.add(root.val);
                root = root.right;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i) - list.get(i - 1) < min)
            {
                min = list.get(i) - list.get(i - 1);
            }
        }
        
        return min;
    }
}
