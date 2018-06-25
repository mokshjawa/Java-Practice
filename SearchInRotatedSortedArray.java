/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/


class Solution {
    public int search(int[] nums, int target) {
        return modifiedBinarySearch(nums, 0, nums.length - 1, target);
    }
    
    public int modifiedBinarySearch(int[] nums, int lo, int hi, int target)
    {
        if (hi >= lo)
        {
            int mid = (lo + hi) / 2;
            int y = nums[mid];
            
            if (y == target)
            {
                return mid;
            }
            
            int x = nums[lo];
            int z = nums[hi];
            
            if (x == target)
            {
                return lo;
            }
            
            if (z == target)
            {
                return hi;
            }
            
            if (x > y)
            {
                if (y < target && target < z)
                {
                    return modifiedBinarySearch(nums, mid + 1, hi - 1, target);
                }
                else
                {
                    return modifiedBinarySearch(nums, lo + 1, mid - 1, target);
                }
            }
            else
            {
                if (x < target && target < y)
                {
                    return modifiedBinarySearch(nums, lo + 1, mid - 1, target);
                }
                else
                {
                    return modifiedBinarySearch(nums, mid + 1, hi - 1, target);
                }
            }
        }
        
        return -1;
    }
}