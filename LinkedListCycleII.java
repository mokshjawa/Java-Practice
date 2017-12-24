/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
- this can be completed using cycling detection algorithm (tortoise and hare)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
        {
            return null;
        }
        
        HashSet<ListNode> visited = new HashSet<>();
        
        for (ListNode i = head; i != null; i = i.next)
        {
            if (visited.contains(i))
            {
                return i;
            }
            else
            {
                visited.add(i);
            }
        }
        
        return null;
    }
}