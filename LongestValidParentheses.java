/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

class Solution {
    public int longestValidParentheses(String s) 
    {
        int maxLength = 0;
        
        if (s == null || s.length() == 0)
        {
            return maxLength;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();

                if (stack.isEmpty())
                {
                    stack.push(i);
                }
                else
                {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
