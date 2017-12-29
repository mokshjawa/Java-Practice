/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

class Solution {
    public int romanToInt(String s) {
        int tgt = 0;
        int[] val = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'M')
            {
                val[i] = 1000;
            }
            else if (s.charAt(i) == 'D')
            {
                val[i] = 500;
            }
            else if (s.charAt(i) == 'C')
            {
                val[i] = 100;
            }
            else if (s.charAt(i) == 'L')
            {
                val[i] = 50;
            }
            else if (s.charAt(i) == 'X')
            {
                val[i] = 10;
            }
            else if (s.charAt(i) == 'I')
            {
                val[i] = 1;
            }
        }
        
        for (int i = 0; i < val.length - 1; i++)
        {
            if (val[i] < val[i+1])
            {
                tgt -= val[i];
            }
            else
            {
                tgt += val[i];
            }
        }
        
        tgt += val[val.length - 1];
        
        return tgt;
    }
}