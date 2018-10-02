/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> tgt = new ArrayList<>();
        
        if (strs == null || strs.length == 0)
        {
            return tgt;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String convert = String.valueOf(arr);
            
            if (!map.containsKey(convert))
            {
                map.put(convert, new ArrayList<>());
            }
            
            map.get(convert).add(str);
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            tgt.add(entry.getValue());
        }
        
        return tgt;   
    }
}
