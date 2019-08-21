/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> tgt = new ArrayList<>();
        helper(tgt, "", n, n);
        return tgt;
    }
    
    private void helper(List<String> tgt, String curr, int left, int right)
    {
        if (right == 0)
        {
            tgt.add(curr);
            return;
        }
        
        if (left > 0)
        {
            helper(tgt, curr + "(", left - 1, right);
        }
        
        if (right > left)
        {
            helper(tgt, curr + ")", left, right - 1);
        }
    }
}