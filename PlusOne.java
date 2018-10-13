/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

class Solution {
    public int[] plusOne(int[] digits) 
    {
        return helper(digits, digits.length - 1);
    }
    
    public int[] helper(int[] digits, int loc)
    {
        if (loc == -1)
        {
            return shift(digits);
        }
        
        digits[loc] += 1;
        
        if (digits[loc] == 10)
        {
            digits[loc] = 0;
            return helper(digits, loc - 1);
        }
        else
        {
            return digits;
        }
    }
    
    public int[] shift(int[] digits)
    {
        int[] tgt = new int[digits.length + 1];
        tgt[0] = 1;
        
        for (int i = 1; i < tgt.length; i++)
        {
            tgt[i] = digits[i - 1];
        }
        
        return tgt;
    }
}
