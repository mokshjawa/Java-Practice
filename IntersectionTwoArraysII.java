/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> tgt = new ArrayList<>();
        
        if (nums1.length <= nums2.length)
        {
            for (int i = 0; i < nums1.length; i++)
            {
                if (map.containsKey(nums1[i]))
                {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                }
                else
                {
                    map.put(nums1[i], 1);
                }
            }
            
            for (int i : nums2)
            {
                if (map.containsKey(i))
                {
                    int val = map.get(i) - 1;
                    tgt.add(i);
                    
                    if (val == 0)
                    {
                        map.remove(i);
                    }
                    else
                    {
                        map.put(i, val);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < nums2.length; i++)
            {
                if (map.containsKey(nums2[i]))
                {
                    map.put(nums2[i], map.get(nums2[i]) + 1);
                }
                else
                {
                    map.put(nums2[i], 1);
                }
            }
            
            for (int i : nums1)
            {
                if (map.containsKey(i))
                {
                    int val = map.get(i) - 1;
                    tgt.add(i);
                    
                    if (val == 0)
                    {
                        map.remove(i);
                    }
                    else
                    {
                        map.put(i, val);
                    }
                }
            }
        }
        
        int[] fin = new int[tgt.size()];
        
        int ind = 0;
        for (Integer i : tgt)
        {
            fin[ind] = i;
            ind++;
        }
        
        return fin;
    }
}
