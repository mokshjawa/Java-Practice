/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        
        int i = 0;
        int j = nums.length - 1;
        int[] tgt = {-1, -1};
        
        while (i <= j)
        {
            int mid = (i + j) / 2;
            System.out.println("mid " + mid);
            
            if (nums[mid] > target)
            {
                j = mid - 1;
            }
            else if (nums[mid] < target)
            {
                i = mid + 1;
            }
            else
            {
                return findRange(nums, mid, target, j);
            }
        }
        
        return tgt;
    }
    
    public int[] findRange(int[] nums, int location, int target, int high)
    {
        int[] tgt = new int[2];
        int index = location;
        
        while (index >= 0 && nums[index] == target)
        {
            index--;
        }
        tgt[0] = index + 1;
        
        index = location;
        
        while (index <= high && nums[index] == target)
        {
            index++;
        }
        tgt[1] = index - 1;
        
        return tgt;       
    }
}