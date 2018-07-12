/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

class Solution {
    public String reverseString(String s) 
    {
        String tgt = "";
        char[] arr = s.toCharArray();
        char[] nex = new char[s.length()];
        
        for (int i = 0; i < arr.length; i++)
        {
            nex[i] = arr[arr.length - 1 - i];
        }
        
        return new String(nex);
    }
}
