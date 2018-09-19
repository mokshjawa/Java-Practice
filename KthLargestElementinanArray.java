/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        shuffle(nums);
        int loIndex = 0;
        int hiIndex = nums.length - 1;
        int targetIndex = nums.length - k;
        
        while (true)
        {
            int partitionIndex = partition(nums, loIndex, hiIndex);
            
            if (targetIndex > partitionIndex) 
            {
                loIndex = partitionIndex + 1;
            } 
            else if (targetIndex < partitionIndex) 
            {
                hiIndex = partitionIndex - 1;
            } 
            else 
            {
                break;
            }
        }
        
        return nums[targetIndex];
    }
    
    private int partition(int[] nums, int loIndex, int hiIndex) 
    {
        int pivotValue = nums[loIndex];
        int pivotIndex = loIndex;
        loIndex++;

        while (loIndex <= hiIndex) 
        { 
            if (nums[loIndex] < pivotValue) 
            {
                loIndex++;  
            } 
            else if (nums[hiIndex] >= pivotValue) 
            {
                hiIndex--;
            } 
            else 
            {
                swap(nums, loIndex, hiIndex);
            }                
        }

        swap(nums, pivotIndex, hiIndex);
        
        return hiIndex;
    }
    
    private void swap(int[] arr, int i, int j) 
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private void shuffle(int[] arr) 
    {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            swap(arr, i, r.nextInt(arr.length));
        }
    }
}
