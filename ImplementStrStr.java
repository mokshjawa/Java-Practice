/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/

class Solution {
    public int strStr(String haystack, String needle) 
    {
        int needleLength = needle.length();
        int hayLength = haystack.length();
        
        if (needleLength > hayLength)
        {
            return -1;
        }
        
        if (needleLength == 0)
        {
            return 0;
        }
        
        for (int i = 0; i <= hayLength - needleLength; i++)
        {
           for (int j = 0; j < needleLength && haystack.charAt(i + j) == needle.charAt(j); j++)
           {
               if (j == needleLength - 1)
               {
                   return i;
               }
           }
        }
        
        return -1;
    }
}