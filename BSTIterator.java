/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) 
    {
        stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null)
        {
            stack.push(curr);
            curr = curr.left;
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !stack.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() 
    {
        TreeNode tgt = stack.pop();
        TreeNode curr = tgt;
        
        if (curr.right != null)
        {
            curr = curr.right;
            stack.push(curr);
            while (curr != null)
            {
                curr = curr.left;
                if (curr != null)
                {
                    stack.push(curr);
                }
            }
        }
        
        return tgt.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
