/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
        
    }
    
    public List<List<Integer>> helper(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> results)
    {
        for (int i = index; i < candidates.length; i++)
        {
            if (candidates[i] > target)
            {
                continue;
            }
            
            List<Integer> newPath = new ArrayList<Integer>(current);
            newPath.add(candidates[i]);
            
            if (candidates[i] == target)
            {
                results.add(newPath);
            }
            else
            {
                helper(candidates, target - candidates[i], i, newPath, results);
            }
        }
        
        return results;
    }
}