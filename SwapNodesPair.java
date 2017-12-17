/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        ListNode store = first;
        
        if (head == null || head.next == null)
        {
            return head;
        }
        
        while (second != null && second.next != null)
        {
            second = second.next;
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            first = first.next.next;
            second = second.next;
        }
        
        return store;
    }
}