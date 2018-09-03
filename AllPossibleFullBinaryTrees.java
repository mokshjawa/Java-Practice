/*
A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.

Each node of each tree in the answer must have node.val = 0.

You may return the final list of trees in any order.

 

Example 1:

Input: 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
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
    public List<TreeNode> allPossibleFBT(int N) 
    {
        List<TreeNode> res = new ArrayList<>();
        
        if (N == 1)
        {
            res.add(new TreeNode(0));
            return res;
        }
        
        N--;
        
        for (int i = 1; i < N; i += 2)
        {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            
            for (TreeNode l : left)
            {
                for (TreeNode r : right)
                {
                    TreeNode n = new TreeNode(0);
                    n.left = l;
                    n.right = r;
                    res.add(n);
                }
            }
        }
        
        return res;
    }
}
