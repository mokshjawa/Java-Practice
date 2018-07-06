/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        Set<Integer> tgt = new HashSet<>();
           
        for (int i : nums1)
        {
            set.add(i);
        }
       
        for (int i : nums2)
        {
            if (set.contains(i))
            {
                tgt.add(i);
            }
        }
       
        int[] result = new int[tgt.size()];
       
        int j = 0;
        for (int i : tgt)
        {
            result[j++] = i;
        }
       
        return result;
    }
}
