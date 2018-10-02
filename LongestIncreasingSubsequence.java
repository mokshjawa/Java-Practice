/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int size = 0;
        int[] tails = new int[nums.length];
        
        for (int n : nums)
        {
            int i = 0;
            int j = size;
            
            while (i != j)
            {
                int m = (i + j) / 2;
                if (tails[m] < n)
                {
                    i = m + 1;
                }
                else
                {
                    j = m;
                }
            }
            
            tails[i] = n;
            
            if (i == size)
            {
                size++;
            }
        }
        
        return size;
    }
}
