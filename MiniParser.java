/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        
        char[] chars = s.toCharArray();
        int len = s.length();
        
        Stack<NestedInteger> stack = new Stack<>();
        int curr = 0;
        
        while (curr < len) {
            if (chars[curr] == '[') {
                stack.push(new NestedInteger());
            }
            else if (Character.isDigit(chars[curr]) || chars[curr] == '-') {
                int num = 0;
                boolean positive = true;
                
                if (chars[curr] == '-') {
                    positive = false;
                    curr++;
                }
                
                while (curr < len && Character.isDigit(chars[curr])) {
                    num = num * 10 + chars[curr] - '0';
                    curr++;
                }
                
                stack.peek().getList().add(new NestedInteger((positive ? 1 : -1) * num));
                curr--;
            }
            else if (chars[curr] == ']') {
                NestedInteger nested = stack.pop();
                
                if (stack.isEmpty()) {
                    return nested;
                }
                else {
                    stack.peek().getList().add(nested);
                }
            }
            
            curr++;
        }
        
        return stack.pop();
    }
}