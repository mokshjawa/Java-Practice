/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
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
   public boolean findTarget(TreeNode root, int k)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return false;
        }
       
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
       
        while (curr != null)
        {
            stack.push(curr);
            curr = curr.left;
        }
       
        while (stack.size() > 0)
        {
            curr = stack.pop();
            list.add(curr.val);
           
            if (curr.right != null)
            {
                curr = curr.right;
               
                while (curr != null)
                {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
       
        int x = 0;
        int y = list.size() - 1;
       
        while (x < y)
        {
            if (list.get(x) + list.get(y) == k)
            {
                return true;
            }
            else if (list.get(x) + list.get(y) > k)
            {
                y--;   
            }
            else
            {
                x++;
            }
        }
       
        return false;
    }  
}