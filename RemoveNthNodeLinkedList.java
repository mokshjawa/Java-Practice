/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode current = head;
        ListNode runner = head;
        ListNode previous = head;
        
        if (head.next == null)
        {
            return null;
        }
        
        for (int i = 1; i <= n; i++)
        {
            runner = runner.next;
        }
        
        while (runner != null)
        {
            previous = current;
            current = current.next;
            runner = runner.next;
        }
        
        previous.next = current.next;
        
        if (previous == current)
        {
            return previous.next;
        }
        
        return head;
        
    }
}