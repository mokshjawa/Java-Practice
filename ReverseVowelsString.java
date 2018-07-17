/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String s) 
    {
        String vowels = "";
        List<Integer> indices = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (isVowel(s.charAt(i)))
            {
                vowels += s.charAt(i);
                indices.add(i);
            }
        }
        
        StringBuilder edit = new StringBuilder(s);
        Collections.reverse(indices);
        
        for (int i = 0; i < vowels.length(); i++)
        {
            edit.setCharAt(indices.get(i), vowels.charAt(i));
        }
        
        return edit.toString();
    }
    
    public boolean isVowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
