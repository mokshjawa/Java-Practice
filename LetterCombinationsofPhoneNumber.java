/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    public List<String> letterCombinations(String digits) 
    {
        LinkedList<String> res = new LinkedList<>();
        
        if (digits == null || digits.length() == 0)
        {
            return res;
        }
        
        String[] mappings = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        res.add("");
        
        for (int i = 0; i < digits.length(); i++)
        {
            int digit = Character.getNumericValue(digits.charAt(i));
            
            while (res.peek().length() == i)
            {
                String curr = res.remove();
                
                for (char l : mappings[digit].toCharArray())
                {
                    res.add(curr + l);
                }
            }
        }
        
        return res;
    }
}
