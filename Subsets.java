/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> tgt = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
        {
            return tgt;
        }
        
        Arrays.sort(nums);
        backtrack(tgt, new ArrayList<>(), nums, 0);
        return tgt;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int curr)
    {
        res.add(new ArrayList<>(temp));
        
        for (int i = curr; i < nums.length; i++)
        {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
