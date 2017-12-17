/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode previous = fake;
        ListNode x = head;
        
        while (x != null)
        {
            if (x.val == val)
            {
               previous.next = x.next; 
            }
            else
            {
                previous = x;
            }
            x = x.next;
        }
        
        return fake.next;
    }
}