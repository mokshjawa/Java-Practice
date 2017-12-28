/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


// solved using Sliding Window Technique

/*
Runtime: O(2n) = O(n)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int start = 0;
        int end = 0;
        while (start < n && end < n) {
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                ans = Math.max(ans, end - start);
            }
            else {
                set.remove(s.charAt(start++));
            }
        }
        return ans;
    }
}

// more efficient way (moving start to occurence of repeated letter, not incrementing manually)
// Runtime: O(n)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}