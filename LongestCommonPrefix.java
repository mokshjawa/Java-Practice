/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String maxString = "";
        int min = minStringLength(strs);
        
        if (strs.length == 0)
        {
            return maxString;
        }
        
        while (maxString.length() < min)
        {
            int index = maxString.length();
            char letter = strs[0].charAt(index);
            
            for (String str : strs)
            {
                if (str.charAt(index) != letter)
                {
                    return maxString;
                }
            }
            
            maxString += letter;
        }
        
        return maxString;
    }
    
    public int minStringLength(String[] strs)
    {
        int tgt = Integer.MAX_VALUE;
        
        for (String str : strs)
        {
            if (str.length() < tgt)
            {
                tgt = str.length();
            }
        }
        
        return tgt;
    }
}