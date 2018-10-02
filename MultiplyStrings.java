/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String multiply(String num1, String num2) 
    {
        int uno = num1.length();
        int dos = num2.length();
        int[] tgt = new int[uno + dos];
        
        for (int i = uno - 1; i >= 0; i--)
        {
            int curr = num1.charAt(i) - '0';
            
            for (int j = dos - 1; j >= 0; j--)
            {
                int mult = curr * (num2.charAt(j) - '0');
                int sum = mult + tgt[i + j + 1];
                tgt[i + j] += sum / 10;
                tgt[i + j + 1] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n : tgt)
        {
            if (!(sb.length() == 0 && n == 0))
            {
                sb.append(n);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
