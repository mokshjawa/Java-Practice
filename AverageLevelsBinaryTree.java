/*

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
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
    List<Double> tgt;
    List<Integer> frequencies;
    public List<Double> averageOfLevels(TreeNode root) {
        tgt = new ArrayList<>();
        frequencies = new ArrayList<>();
        for (int i = 0; i < findDepth(root, 0); i++)
        {
            tgt.add(i, 0.0);
            frequencies.add(i, 0);
        }
        
        addNodesToAverage(root, 0);
        
        return tgt;
    }
    
    private void addNodesToAverage(TreeNode node, int depth)
    {
        addToAverage(node, depth);
        if (node.left != null)
        {
            addNodesToAverage(node.left, depth + 1);
        }
        if (node.right != null)
        {
            addNodesToAverage(node.right, depth + 1);
        }
    }
    
    
    private void addToAverage(TreeNode node, int depth)
    {
        tgt.set(depth, (double) (((tgt.get(depth) * frequencies.get(depth)) + node.val) / (frequencies.get(depth) + 1)));
        frequencies.set(depth, frequencies.get(depth) + 1);
    }
    
    private int findDepth(TreeNode node, int depth)
    {
        if (node == null)
        {
            return depth;
        }
        return Math.max(findDepth(node.left, depth + 1), findDepth(node.right, depth + 1));
    }
}