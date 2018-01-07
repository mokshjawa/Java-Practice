/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/

class Solution 
{
    public int countSegments(String s) 
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int tgt = 0;
        boolean lastWasWord = false;
        
        for (char c : chars)
        {
            if (c == ' ')
            {
                if (lastWasWord)
                {
                    tgt++;
                    lastWasWord = false;  
                }
            }
            else
            {
                lastWasWord = true;
            }
        }
        
        if (lastWasWord)
        {
            tgt++;
        }
        
        return tgt;
    }
}