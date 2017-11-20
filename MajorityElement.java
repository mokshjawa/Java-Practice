/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int majLength = nums.length / 2;
        
        for (int n : nums)
        {
            int count = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if (n == nums[i])
                {
                    count++;
                }
            }
            
            if (count > majLength)
            {
                return n;
            }
        }
        
        return -1;
    }
}