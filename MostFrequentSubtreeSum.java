/*
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
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
class Solution
{
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int max = 0;
   
    public int[] findFrequentTreeSum(TreeNode root)
    {
        helper(root);
       
        int[] tgt = new int[list.size()];
       
        for (int i = 0; i < tgt.length; i++)
        {
            tgt[i] = list.get(i);
        }
       
        return tgt;
    }
   
    public int helper(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        
        int sum = helper(root.left) + helper(root.right) + root.val;
       
        if (map.containsKey(sum))
        {
            map.put(sum, map.get(sum) + 1);
        }
        else
        {
            map.put(sum, 1);
        }
       
        int curr = map.get(sum);
       
        if (curr > max)
        {
            max = curr;
            list = new ArrayList<>();
            list.add(sum);
        }
        else if (curr == max)
        {
            list.add(sum);
        }
       
        return sum;
    }
}
