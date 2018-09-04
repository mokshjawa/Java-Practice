/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> tgt = new ArrayList<>();
        backtrack(tgt, new ArrayList<>(), nums);
        return tgt;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums)
    {
        if (temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (temp.contains(nums[i]))
                {
                    continue;
                }
                
                temp.add(nums[i]);
                backtrack(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
