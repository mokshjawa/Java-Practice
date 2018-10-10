/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    public int kthSmallest(TreeNode root, int k) 
    {
        Stack<TreeNode> st = new Stack<>();
        int count = k;
        
        while (root != null)
        {
            st.push(root);
            root = root.left;
        }
        
        while (count != 0)
        {
            TreeNode curr = st.pop();
            count--;
            
            if (count == 0)
            {
                return curr.val;
            }
            
            if (curr.right != null)
            {
                curr = curr.right;
                
                while (curr != null)
                {
                    st.push(curr);
                    curr = curr.left;
                }
            }
        }
        
        return -1;
    }
}
