/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        
        if (length != t.length())
        {
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        char[] sm = new char[256];
        char[] tm = new char[256];
        
        for (int i = 0; i < length; i++)
        {
            char s1 = sArray[i];
            char t1 = tArray[i];
            
            if (sm[s1] == 0 && tm[t1] == 0)
            {
                sm[s1] = t1;
                tm[t1] = s1;
            }
            else
            {
                if (sm[s1] != t1 || tm[t1] != s1)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}