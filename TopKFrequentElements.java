/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) 
    {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i : nums)
        {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            int key = entry.getKey(); 
            int val = entry.getValue(); 
            
            if (buckets[val] == null) 
            {
                buckets[val] = new ArrayList<>(); 
            }
            
            buckets[val].add(key); 
        }
        
        List<Integer> tgt = new ArrayList<>();
        
        for (int i = buckets.length - 1; i > 0 && tgt.size() < k; i--)
        {
            if (buckets[i] != null)
            {
                tgt.addAll(buckets[i]);
            }
        }
        
        return tgt;
    }
}
