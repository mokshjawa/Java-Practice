/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
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
    public TreeNode convertBST(TreeNode root) 
    {
        int sum = 0;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                sum += curr.val;
                curr = curr.right;
            }
        }
        
        stack = new Stack<>();
        curr = root;
        
        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                System.out.print(curr.val);
                sum -= curr.val;
                curr.val += sum;
                System.out.print(curr.val);
                curr = curr.right;
            }
        }
        
        return root;
    }
}
