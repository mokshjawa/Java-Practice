class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        
        int result = 0;
        int sign = 1;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
            
            if (Character.isDigit(curr)) {
                int num = curr - '0';
                
                while (i + 1 < arr.length && Character.isDigit(arr[i+1])) {
                    num = num * 10 + arr[i+1] - '0';
                    i++;
                }
                
                result += num * sign;
            }
            else if (curr == '+' || curr == '-') {
                sign = curr == '+' ? 1 : -1;
            }
            else if (curr == '(') {
                stack.push(result);
                stack.push(sign);
                
                result = 0;
                sign = 1;
            }
            else if (curr == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        
        return result;
        
    }
}