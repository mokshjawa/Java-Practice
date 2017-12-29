/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
    public boolean isValid(String s) 
    {
	    if (s == null || s.length() == 0 || s.length() % 2 != 0)
        {
            return false;
        }
        
        Stack<Character> closers = new Stack<Character>();
	    for (char c : s.toCharArray()) 
        {
		    if (c == '(')
			    closers.push(')');
            else if (c == '{')
                closers.push('}');
            else if (c == '[')
                closers.push(']');
            else if (closers.isEmpty() || closers.pop() != c)
                return false;
        }
        return closers.isEmpty();
    }
}