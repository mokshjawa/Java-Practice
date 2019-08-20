/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    public void helper(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> results)
    {
        if (target == 0)
        {
            results.add(new ArrayList<Integer>(current));
            return;
        }
        else if (target < 0 || index == candidates.length)
        {
            return;
        }
        
        current.add(candidates[index]);
        helper(candidates, target - candidates[index], index + 1, current, results);
        current.remove(current.size() - 1);
        
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1])
        {
            index++;
        }
        
        helper(candidates, target, index + 1, current, results);
    }
}