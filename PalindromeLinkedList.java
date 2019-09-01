/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
        {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        
        while (firstHalf != null && secondHalf != null)
        {
            if (firstHalf.val != secondHalf.val)
            {
                return false;
            }
            
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        
        ListNode nextNode = head.next;
        ListNode reversed = reverse(nextNode);
        nextNode.next = head;
        head.next = null;
        return reversed;
    }
    
}