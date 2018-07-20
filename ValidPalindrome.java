/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class Solution {
    public boolean isPalindrome(String s)
    {
        char[] arr = s.toCharArray();
       
        int i = 0;
        int j = s.length() - 1;
       
        while (i < j)
        {
            while (!isValid(arr[i]))
            {
                i++;
               
                if (i == arr.length)
                {
                    return true;
                }
            }
           
            while (!isValid(arr[j]))
            {
                j--;
            }
           
            if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j]))
            {
                return false;
            }
           
            i++;
            j--;
        }
       
        return true;
    }
   
    public boolean isValid(char c)
    {
        return ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122));
    }
}
