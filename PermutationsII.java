/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tgt = new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), tgt);
        return tgt;
    }
    
    public void helper(int[] nums, boolean[] isUsed, List<Integer> current, List<List<Integer>> tgt)
    {
        if (current.size() == nums.length)
        {
            tgt.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            if (isUsed[i] || (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]))
            {
                continue;
            }
            
            current.add(nums[i]);
            isUsed[i] = true;
            helper(nums, isUsed, current, tgt);
            isUsed[i] = false;
            current.remove(current.size() - 1);
        }
    }
}