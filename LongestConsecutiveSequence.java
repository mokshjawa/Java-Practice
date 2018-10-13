/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

class Solution {
    public int longestConsecutive(int[] nums) 
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums)
        {
            set.add(num);
        }
        
        int max = 0;
        
        for (int n : set)
        {
            if (!set.contains(n - 1))
            {
                int curr = n;
                int currStreak = 1;
                
                while (set.contains(curr + 1))
                {
                    curr++;
                    currStreak++;
                }
                
                max = Math.max(max, currStreak);
            }
        }
        
        return max;
    }
}
