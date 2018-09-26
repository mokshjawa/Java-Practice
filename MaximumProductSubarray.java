/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) 
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int max = nums[0];
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        maxs[0] = max;
        mins[0] = max;
        
        for (int i = 1; i < nums.length; i++)
        {
            maxs[i] = Math.max(Math.max(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]), nums[i]);
            mins[i] = Math.min(Math.min(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]), nums[i]);
            max = Math.max(max, maxs[i]);
        }
        
        return max;
    }
}
